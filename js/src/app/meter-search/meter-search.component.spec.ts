import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MeterSearchComponent } from './meter-search.component';

describe('MeterSearchComponent', () => {
  let component: MeterSearchComponent;
  let fixture: ComponentFixture<MeterSearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MeterSearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MeterSearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
