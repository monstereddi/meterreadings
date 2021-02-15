import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Location } from '@angular/common';

import { Meter } from '../meter';
import { MeterService } from '../meter.service';

@Component({
  selector: 'app-meter-detail',
  templateUrl: './meter-detail.component.html',
  styleUrls: ['./meter-detail.component.css']
})
export class MeterDetailComponent implements OnInit {

  constructor(
    private route: ActivatedRoute,
    private meterService: MeterService,
    private location: Location
  ) { }

  @Input() meter: Meter;

  ngOnInit(): void {
    this.getMeter();
  }

  getMeter(): void {
    const id = + this.route.snapshot.paramMap.get('id');
    this.meterService.getMeter(id)
      .subscribe(meter => this.meter = meter);
  }

  goBack(): void {
    this.location.back();
  }

  save(): void {
    this.meterService.updateMeter(this.meter)
      .subscribe(() => this.goBack());
  }
}
