import { ApiService } from './../services/api.service';
import { Component, OnInit } from '@angular/core';
import { Response } from '../models/response.model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  user: Response;
  error: Error;
  constructor(private apiService: ApiService) { }

  ngOnInit(): void {
    
  }

  callUserApi(){
    this.apiService.getUser().subscribe({
      next: (res) => {
        this.user = res;
        this.error = null;
      },
      error: (err) => {
        this.user = null;
        this.error = err;
      }
    })
  }

  
  callAdminApi(){
    this.apiService.getAdmin().subscribe({
      next: (res) => {
        this.user = res;
        this.error = null;
      },
      error: (err) => {
        this.user = null;
        this.error = err;
      }
    })
  }
}
