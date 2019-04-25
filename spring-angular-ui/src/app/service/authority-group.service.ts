import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { AuthorityGroup } from '../models/authority-group';

@Injectable()
export class AuthorityGroupService {

  private AUTHORITY_GROUP_RESOURCE = '/api/authority-groups/';

  constructor(private httpClient: HttpClient) {
  }

  public getAuthorityGroups(): Observable<AuthorityGroup[]> {
    return this.httpClient.get<AuthorityGroup[]>(this.AUTHORITY_GROUP_RESOURCE);
  }

  public getAuthorityGroupById(id: number): Observable<AuthorityGroup> {
    return this.httpClient.get<AuthorityGroup>(this.AUTHORITY_GROUP_RESOURCE + id);
  }

  public createAuthorityGroup(authorityGroup: AuthorityGroup): Observable<AuthorityGroup> {
    const authorityGroupSerialized = JSON.stringify(authorityGroup);
    return this.httpClient.post<AuthorityGroup>(this.AUTHORITY_GROUP_RESOURCE, authorityGroupSerialized, this.getHeaderOptions());
  }

  public updateAuthorityGroup(authorityGroup: AuthorityGroup): Observable<AuthorityGroup> {
    const authorityGroupSerialized = JSON.stringify(authorityGroup);
    return this.httpClient.put<AuthorityGroup>(this.AUTHORITY_GROUP_RESOURCE, authorityGroupSerialized, this.getHeaderOptions());
  }

  public deleteAuthorityGroup(id: number): Observable<number> {
    return this.httpClient.delete<number>(this.AUTHORITY_GROUP_RESOURCE + id);
  }

  private getHeaderOptions() {
    const httpOptions = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    };

    return httpOptions;
  }

}
