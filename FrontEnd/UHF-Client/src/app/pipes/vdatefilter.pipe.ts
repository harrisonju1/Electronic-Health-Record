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
        let dateConvert = new Date(it.visit_date);
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
