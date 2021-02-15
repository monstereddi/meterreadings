import { Component, OnInit } from '@angular/core';

import { Observable, Subject } from 'rxjs';

import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';

import { Meter } from '../meter';
import { MeterService } from '../meter.service';

@Component({
  selector: 'app-meter-search',
  templateUrl: './meter-search.component.html',
  styleUrls: ['./meter-search.component.css']
})
export class MeterSearchComponent implements OnInit {

  meters$: Observable<Meter[]>;
  private searchTerms = new Subject<string>();

  // Push a search term into the observable stream.
  search(term: string): void {
    this.searchTerms.next(term);
  }

  constructor(private meterService: MeterService) { }

  ngOnInit(): void {
    this.meters$ = this.searchTerms.pipe(
      // wait 300ms after each keystroke before considering the term
      debounceTime(300),

      // ignore new term if same as previous term
      distinctUntilChanged(),

      // switch to new search observable each time the term changes
      switchMap((term: string) => this.meterService.searchMeters(term))
    );
  }
}
