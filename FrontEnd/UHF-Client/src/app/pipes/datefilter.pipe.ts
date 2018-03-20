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
        let dateConvert = new Date(it.dob);
        let month = dateConvert.getMonth()+1;
        let day = dateConvert.getDate();
        let year = dateConvert.getFullYear();
        let date = month + "/" + day + "/" + year;
        return date.includes(searchDate);
      });  
    });
    return items;
  }

}
