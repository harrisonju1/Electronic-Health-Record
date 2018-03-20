import { Pipe, PipeTransform } from '@angular/core';
import { ApptRecord } from '../domain/ApptRecord';

@Pipe({
  name: 'vdatefilter'
})
export class VdatefilterPipe implements PipeTransform {

  transform(items: ApptRecord[], searchDate: string): ApptRecord[] {

    if (!items || !searchDate){
      return items;
    }

    items.forEach(item => {
      items =  items.filter( it => {
        let month = it.visit_date.getMonth()+1;
        let day = it.visit_date.getDate();
        let year = it.visit_date.getFullYear();
        let date = month + "/" + day + "/" + year;
        return date.includes(searchDate);
      });  
    });
    return items;
  }

}
