import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './header/header.component';
import { HomeComponent } from './home/home.component';
import { AuthorityGroupListComponent } from './authority-group-list/authority-group-list.component';
import { AuthorityGroupFormComponent } from './authority-group-form/authority-group-form.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { AuthorityGroupService } from './service/authority-group.service';

@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    AuthorityGroupListComponent,
    AuthorityGroupFormComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule

  ],
  providers: [AuthorityGroupService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
