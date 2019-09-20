import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {AppRoutingModule} from './app-routing.module';
import {FormsModule} from '@angular/forms';
import {HttpClientModule} from '@angular/common/http';
import {AppComponent} from './app.component';
import {GameComponent} from './game/game.component';
import {PlayerFormComponent} from './player-form/player-form.component';
import {PlayerService} from './service/player.service';
import {GameService} from './service/game.service';
import {Player} from "./model/player";
import {PlayerListComponent} from "./player-list/player-list.component";

@NgModule({
  declarations: [
    AppComponent,
    GameComponent,
    PlayerFormComponent,
    PlayerListComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    PlayerService,
    GameService,
    Player
  ],
  bootstrap: [AppComponent]
})
export class AppModule {
}
