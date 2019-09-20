import {async, ComponentFixture, TestBed} from '@angular/core/testing';

import {PlayerFormComponent} from './player-form.component';
import {Player} from "../model/player";
import {PlayerService} from "../service/player.service";
import {HttpClientModule} from "../../../node_modules/@angular/common/http";
import {FormsModule} from "@angular/forms";
import {RouterTestingModule} from "../../../node_modules/@angular/router/testing";

describe('PlayerFormComponent', () => {
  let component: PlayerFormComponent;
  let fixture: ComponentFixture<PlayerFormComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        PlayerFormComponent
      ],
      imports: [
        HttpClientModule,
        FormsModule,
        RouterTestingModule
      ],
      providers: [
        Player,
        PlayerService
      ]
    })
      .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PlayerFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
