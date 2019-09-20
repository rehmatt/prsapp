import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Result} from "../model/result";
import {Move} from "../model/move";

@Injectable()
export class GameService {

  private readonly playUrl: string;

  constructor(private http: HttpClient) {
    this.playUrl = 'http://localhost:8080/play';
  }

  public play(move: Move) {
    return this.http.post<Result>(this.playUrl, move);
  }
}
