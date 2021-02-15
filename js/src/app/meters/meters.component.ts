import { Component, OnInit } from '@angular/core';

import { Meter } from '../meter';
import { MeterService } from '../meter.service';
import { MessageService } from '../message.service';


@Component({
  selector: 'app-meters',
  templateUrl: './meters.component.html',
  styleUrls: ['./meters.component.css']
})
export class MetersComponent implements OnInit {

  meters: Meter[];

  constructor(private meterService: MeterService) {}

  ngOnInit(): void {
    this.getMeters();
  }

  getMeters(): void {
    this.meterService.getMeters()
        .subscribe(meters => this.meters = meters);
  }

  add(name: string): void {
    name = name.trim();
    if (!name) { return; }
    this.meterService.addMeter({ name } as Meter)
      .subscribe(meter => {this.meters.push(meter); });
  }

  delete(meter: Meter): void {
    this.meters = this.meters.filter(m => m !== meter);
    this.meterService.deleteMeter(meter).subscribe();
  }
}
