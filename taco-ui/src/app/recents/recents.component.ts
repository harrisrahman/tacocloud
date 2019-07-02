import { Component, OnInit, Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';

@Component({
  selector: 'app-recents',
  templateUrl: './recents.component.html',
  styleUrls: ['./recents.component.css']
})

@Injectable()
export class RecentTacosComponent implements OnInit {
  recentTacos: any;


  constructor(private httpClient : HttpClient) { }

  ngOnInit() {
    this.httpClient.get('http://localhost:8080/design/recent')
        .subscribe(data => this.recentTacos = data);



  }

}
