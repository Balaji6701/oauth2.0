import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { Response } from '../models/response.model';

@Injectable({
  providedIn: 'root'
})
export class ApiService {

  constructor(private http:HttpClient) { }

  getAdmin(){
    return this.http.get<Response>(environment.rootUrl+ 'products/admin')
  }

  
  getUser(){
    return this.http.get<Response>(environment.rootUrl+ 'products')
  }
}
