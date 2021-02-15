import { Component, OnInit } from '@angular/core';

import { Meter } from '../meter';
import { MeterService } from '../meter.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  meters: Meter[] = [];

  constructor(private meterService: MeterService) { }

  ngOnInit(): void {
    this.getMeters();
  }

  getMeters(): void {
    this.meterService.getMeters()
      .subscribe(meters => this.meters = meters.slice(1, 5));
  }
}
