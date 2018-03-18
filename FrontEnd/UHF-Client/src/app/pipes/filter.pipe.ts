import { Pipe, PipeTransform } from '@angular/core';
import { PatientProfile } from './../domain/PatientProfile';

@Pipe({
  name: 'filter'
})

export class FilterPipe implements PipeTransform {
  transform(items: PatientProfile[], searchText: any): PatientProfile[] {
    let arr: PatientProfile[];
    
    if (!items || !searchText){
      return items;
    }
    
    items.forEach(item => {
      if (typeof searchText === 'string'){
        searchText = searchText.toLowerCase();
        arr =  items.filter( it => {
          let f = it.firstname.toLowerCase();
          let l = it.lastname.toLowerCase();
          let name = f + " " + l;
          return name.includes(searchText);
        });
      }
      else if (typeof searchText === 'number'){
        arr =  items.filter( it => {
          return it.patient_id === searchText;
        });
      }
    });

    return arr;
   }
}