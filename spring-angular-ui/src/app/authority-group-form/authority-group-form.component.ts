import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { Subscription } from 'rxjs';
import { AuthorityGroup } from '../models/authority-group';
import { AuthorityGroupService } from '../service/authority-group.service';

@Component({
  selector: 'app-authority-group-form',
  templateUrl: './authority-group-form.component.html'
})
export class AuthorityGroupFormComponent implements OnInit {

  public authorityGroupForm: FormGroup;
  public isNew = true;
  private subscription: Subscription;
  private authorityGroup: AuthorityGroup;

  constructor(private formBuilder: FormBuilder,
              private router: Router,
              private activeRoute: ActivatedRoute,
              private authorityGroupService: AuthorityGroupService) { }

  public ngOnInit(): void {
    this.initializeDefaultForm();
    this.renderForm();
  }

  public onSubmit(): void {
    const authorityGroup = this.authorityGroupForm.value;
    if (this.isNew) {
      this.authorityGroupService.createAuthorityGroup(authorityGroup)
        .subscribe(response => {
          this.router.navigate(['authority-groups']);
        });
    } else {
      this.authorityGroupService.updateAuthorityGroup(authorityGroup)
        .subscribe(response => {
          this.router.navigate(['authority-groups']);
        });;
    }
  }

  public onBack(): void {
    this.router.navigate(['']);
  }

  private initializeDefaultForm(authorityGroup?: AuthorityGroup): void {
    this.authorityGroupForm = this.formBuilder.group({
      id: authorityGroup ? authorityGroup.id : 0,
      name: authorityGroup ? authorityGroup.name : ''
    });
  }

  private renderForm(): void {
    // Verify if it's for edit
    this.subscription = this.activeRoute.params.subscribe(
      (parameters: Params) => {
        // tslint:disable-next-line:no-string-literal
        const id: number = +parameters['id']; // (+) Converts string 'id' to a number
        if (id && id > 0) {
          this.authorityGroupService.getAuthorityGroupById(id)
            .subscribe((authorityGroup: AuthorityGroup) => {
              this.isNew = false;
              this.initializeDefaultForm(authorityGroup);
            });
        }
      });
  }

}
