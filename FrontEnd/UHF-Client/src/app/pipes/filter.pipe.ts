import { Pipe, PipeTransform } from '@angular/core';
import { PatientProfile } from './../domain/PatientProfile';

@Pipe({
  name: 'filter'
})

export class FilterPipe implements PipeTransform {
  transform(items: PatientProfile[], searchText: any): PatientProfile[] {
    
    if (!items || !searchText){
      return items;
    }
    
    items.forEach(item => {
        searchText = searchText.toLowerCase();
        items =  items.filter( it => {
          let f = it.firstname.toLowerCase();
          let l = it.lastname.toLowerCase();
          let name = f + " " + l;
          return name.includes(searchText);
        });
    });

    return items;
   }
}