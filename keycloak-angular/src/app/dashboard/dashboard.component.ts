import { ApiService } from './../services/api.service';
import { Component, OnInit } from '@angular/core';
import { Response } from '../models/response.model';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user: Response;
  error: string;
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    
  }

  callUserApi(){
    this.apiService.getUser().subscribe({
      next: (res) => {
        this.user = res;
        this.error = null;
      },
      error: (err: HttpErrorResponse) => {
        if(err.status === 403){
          this.error = "Un-authorized"
        }
        this.user = null;
      }
    })
  }

  
  callAdminApi(){
    this.apiService.getAdmin().subscribe({
      next: (res) => {
        this.user = res;
        this.error = null;
      },
      error: (err:HttpErrorResponse) => {
        if(err.status === 403){
          this.error = "Un-authorized"
        }
        this.user = null;
      }
    })
  }
}
