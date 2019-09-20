import {inject, TestBed} from '@angular/core/testing';

import {PlayerService} from './player.service';
import {HttpClient, HttpHandler} from "@angular/common/http";

describe('PlayerService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [
        PlayerService,
        HttpClient,
        HttpHandler
      ]
    });
  });

  it('should be created', inject([PlayerService], (service: PlayerService) => {
    expect(service).toBeTruthy();
  }));
});
