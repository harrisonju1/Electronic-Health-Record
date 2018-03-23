import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'docidfilter'
})
export class DocidfilterPipe implements PipeTransform {

  transform(items: any[], searchID: number): any[] {

    if (!items || !searchID) {
      return items;
    }

    items.forEach(item => {
      items = items.filter(it => {
        return it.doctor_id === searchID;
      });
    });
    return items;
  }

}
