import { Pipe, PipeTransform } from '@angular/core';
import { PatientProfile } from '../domain/PatientProfile';

@Pipe({
  name: 'idfilter'
})
export class IdfilterPipe implements PipeTransform {

  transform(items: PatientProfile[], searchID: number): PatientProfile[] {
    let arr: PatientProfile[];

    if (!items || !searchID){
      return items;
    }

    items.forEach(item => {
      arr =  items.filter( it => {
        return it.patient_id === searchID;
      });  
    });
    return arr;
  }
}
