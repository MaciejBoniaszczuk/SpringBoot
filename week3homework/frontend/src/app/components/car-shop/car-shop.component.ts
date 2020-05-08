import { Component, OnInit } from '@angular/core';
import {CarClientService, Content, RootObject} from '../../services/car-client.service';

@Component({
  selector: 'app-car-shop',
  templateUrl: './car-shop.component.html',
  styleUrls: ['./car-shop.component.css']
})
export class CarShopComponent implements OnInit {

  rootObject: RootObject;
  rootObject1: RootObject;
  carId: number;
  content: Content[];
  carById: Content;
  flag: boolean;
  constructor(private carClientService: CarClientService) {
  }
  ngOnInit(): void {
    this.flag = false;
    this.carClientService.getCars().subscribe(value => {
      this.rootObject = value;
    });
  }

  showCars() {
    this.content = this.rootObject.content;
    this.flag = !this.flag;
  }

  showCarsById(value: number) {
    this.carId = value;
    console.log(name);
    this.carById = this.rootObject.content[value - 1];
    console.log(this.carById);
  }
  addCar(value: number, value2: string, value3: string, value4: string) {
    console.log(value, value2, value3, value4);
    this.carClientService.createPostData(value, value2, value3, value4);
    this.carClientService.addCar();
    console.log('wywolana metoda addCar');
  }
  modCar(value: number, value2: string, value3: string, value4: string) {
    console.log(value, value2, value3, value4);
    this.carClientService.createPostData(value, value2, value3, value4);
    this.carClientService.modCar();
    console.log('wywolana metoda addCar');
  }

  refresh()  {
    if (!this.flag) {
    window.location.reload();
    }
  }

  deleteCar(carDelId: string) {
    this.carClientService.deleteCar(carDelId);
  }
}
