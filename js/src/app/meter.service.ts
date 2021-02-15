import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

import { Meter } from './meter';
// import { METERS } from './mock-meters';
import { MessageService } from './message.service';

@Injectable({
  providedIn: 'root'
})
export class MeterService {

  constructor(private messageService: MessageService, private http: HttpClient) { }

  private metersUrl = 'http://localhost:8080/meters'; // 'api/meters';// URL to web api

  httpOptions = {
    headers: new HttpHeaders({ 'Content-Type': 'application/json' })
  };

  // this gets the Meters from the mock file.
  // getMeters(): Observable<Meter[]> {
  //   return of(METERS);
  // }
  /** GET the meters form the server */
  getMeters(): Observable<Meter[]> {
    return this.http.get<Meter[]>(this.metersUrl)
      .pipe(
        tap(_ => this.log('fetched meters')),
        catchError(this.handleError<Meter[]>('getMeters', []))
      );
  }

  // This gets a single meter from the mock-meter
  // getMeter(id: number): Observable<Meter> {
  //   this.messageService.add(`MeterService: fetched meter id=${id}`);
  //   return of(METERS.find(meter => meter.id ===id));
  // }
  /** GET meter by id. Will 404 if not found */
  getMeter(id: number): Observable<Meter> {
    const url = `${this.metersUrl}/${id}`;
    return this.http.get<Meter>(url)
      .pipe(
        tap(_ => this.log(`fetched meter id=${id}`)),
        catchError(this.handleError<Meter>(`getMeter id=${id}`))
      );
  }

  /** PUT updated meter */
  updateMeter(meter: Meter): Observable<any> {
    return this.http.put(this.metersUrl, meter, this.httpOptions)
      .pipe(
        tap(_ => this.log(`updated meter id=${meter.id}`)),
        catchError(this.handleError<any>('updateMeter'))
      );
  }

  /** POST: add a new meter to the server */
  addMeter(meter: Meter): Observable<Meter> {
    return this.http.post<Meter>(this.metersUrl.concat('/add'), meter, this.httpOptions)
      .pipe(
        tap((newMeter: Meter) => this.log(`added meter w/ id=${newMeter.name}`)),
        catchError(this.handleError<Meter>('addMeter'))
      );
  }

  /** DELETE: delete the meter from the server */
  deleteMeter(meter: Meter | number): Observable<Meter> {
    const id = typeof meter === 'number' ? meter : meter.id;
    const url = `${this.metersUrl}/delete/${id}`;

    return this.http.delete<Meter>(url, this.httpOptions)
      .pipe(
        tap(_ => this.log(`deleted meter id=${id}`)),
        catchError(this.handleError<Meter>('deleteMeter'))
      );
  }

  /** GET meters whose name contains search term */
  searchMeters(term: string): Observable<Meter[]> {
    if (!term.trim()) {
      // if not search term, return empty meter array
      return of([]);
    }
    return this.http.get<Meter[]>(`${this.metersUrl}/?name=${term}`)
      .pipe(
        tap(x => x.length ?
          this.log(`found meters matching "${term}"`) :
          this.log(`no heroes matching "${term}"`)),
          catchError(this.handleError<Meter[]>('searchMeters', []))
      );
  }

  /** Log a MeterService message with the MessageService */
  private log(message: string): void {
    this.messageService.add(`MeterService: ${message}`);
  }

  private handleError = <T>(operation = 'operation', result?: T) => (error: any): Observable<T> => {

    // TODO: send the error to remote logging infrastructure
    console.error(error); // log to console instead

    // TODO: better job of transforming error for user consumption
    this.log(`${operation} failed: ${error.message}`);

    // Let the app keep running by returning an empty result.
    return of(result as T);
  }
}
