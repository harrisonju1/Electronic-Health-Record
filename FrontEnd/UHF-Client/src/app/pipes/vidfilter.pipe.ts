import { Pipe, PipeTransform } from '@angular/core';
import { ApptRecord } from '../domain/ApptRecord';

@Pipe({
  name: 'vidfilter'
})
export class VidfilterPipe implements PipeTransform {

  transform(items: ApptRecord[], searchID: number): ApptRecord[] {

    if (!items || !searchID){
      return items;
    }

    items.forEach(item => {
      items =  items.filter( it => {
        return it.visit_id === searchID;
      });  
    });
    return items;
  }

}
