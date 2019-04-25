import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AuthorityGroupListComponent } from './authority-group-list/authority-group-list.component';
import { AuthorityGroupFormComponent } from './authority-group-form/authority-group-form.component';

const routes: Routes = [
  { path: '', component: AuthorityGroupListComponent },
  { path: 'create', component: AuthorityGroupFormComponent },
  { path: ':id', component: AuthorityGroupFormComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
