import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Meter } from './meter';

@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService {

    createDb() {
      const meters = [
        { id: 11, name: 'Auto1' },
        { id: 12, name: 'Strom' },
        { id: 13, name: 'Wasser' },
        { id: 14, name: 'Müll' },
        { id: 15, name: 'Auto2' }
      ];
      return {meters};
    }


    genId(meters: Meter[]): number {
      return meters.length > 0 ? Math.max(...meters.map(meter => meter.id)) + 1 : 11;
  }

}
