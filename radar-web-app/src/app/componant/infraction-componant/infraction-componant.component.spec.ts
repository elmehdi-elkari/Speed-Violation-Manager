import { ComponentFixture, TestBed } from '@angular/core/testing';

import { InfractionComponantComponent } from './infraction-componant.component';

describe('InfractionComponantComponent', () => {
  let component: InfractionComponantComponent;
  let fixture: ComponentFixture<InfractionComponantComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [InfractionComponantComponent]
    });
    fixture = TestBed.createComponent(InfractionComponantComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
