import { Pipe, PipeTransform } from '@angular/core';
import { PatientProfile } from '../domain/PatientProfile';

@Pipe({
  name: 'datefilter'
})
export class DatefilterPipe implements PipeTransform {

  transform(items: PatientProfile[], searchDate: string): PatientProfile[] {

    if (!items || !searchDate){
      return items;
    }

    items.forEach(item => {
      items =  items.filter( it => {
        let month = it.dob.getMonth()+1;
        let day = it.dob.getDate();
        let year = it.dob.getFullYear();
        let date = month + "/" + day + "/" + year;
        return date.includes(searchDate);
      });  
    });
    return items;
  }

}
