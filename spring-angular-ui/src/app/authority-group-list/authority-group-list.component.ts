import { Component, OnInit } from '@angular/core';
import { AuthorityGroup } from '../models/authority-group'
import { AuthorityGroupService } from '../service/authority-group.service';

@Component({
  selector: 'app-authority-group-list',
  templateUrl: './authority-group-list.component.html',
})
export class AuthorityGroupListComponent implements OnInit {

  public authorityGroups: AuthorityGroup[];

  constructor(private authorityGroupService: AuthorityGroupService) {
  }

  public ngOnInit(): void {
    this.getAuthorityGroups();
  }

  public onDelete(id: number, index: number): boolean {
    this.authorityGroupService.deleteAuthorityGroup(id)
      .subscribe(() => {
        this.authorityGroups.splice(index, 1);
      });

    return false;
  }

  private getAuthorityGroups(): void {
    this.authorityGroupService.getAuthorityGroups()
      .subscribe((response: AuthorityGroup[]) => {
        this.authorityGroups = response;
      });
  }

}
