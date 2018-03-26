import { Pipe, PipeTransform } from '@angular/core';
import { PatientProfile } from '../domain/PatientProfile';

@Pipe({
  name: 'idfilter'
})
export class IdfilterPipe implements PipeTransform {

  transform(items: PatientProfile[], searchID: number): PatientProfile[] {

    if (!items || !searchID) {
      return items;
    }

    let s = ""+searchID;

    items.forEach(item => {
      items = items.filter(it => {
        return (""+it.patient_id).includes(s);
      });
    });
    return items;
  }
}
