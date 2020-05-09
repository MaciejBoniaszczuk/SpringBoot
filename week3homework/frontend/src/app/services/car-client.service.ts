import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {CarShopComponent} from '../components/car-shop/car-shop.component';

@Injectable({
  providedIn: 'root'
})
export class CarClientService {
  url = 'http://localhost:8080/cars';
  postData: {};
  constructor(private httpClient: HttpClient) {
  }
  public getCars(): Observable<RootObject>{
    return this.httpClient.get<RootObject>(this.url);
  }
  public createPostData(value: number, value2: string, value3: string, value4: string) {
    this.postData = 	{
      id: value,
      brand: value2,
      model: value3,
      color: value4
    };
  }
  public addCar(){
    this.httpClient.post(this.url, this.postData).toPromise().then(data => {
    });
  }
  public modCar(){
    this.httpClient.put(this.url, this.postData).toPromise().then(data => {
    });
  }
  public deleteCar(id: string){
    this.httpClient.delete(`http://localhost:8080/cars/${id}`).toPromise().then(data => {
    });
  }
}

export interface Link {
    rel: string;
    href: string;
  }
export interface Link2 {
    rel: string;
    href: string;
  }

export interface Content {
    id: number;
    brand: string;
    model: string;
    color: string;
    links: Link2[];
  }

export interface RootObject {
    links: Link[];
    content: Content[];
  }


