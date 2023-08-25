import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {ProduitDTO} from "../model/DetailleCommande";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class ProduitsService {

  constructor(private http:HttpClient) { }


  public getAllProduits (){
    const token=localStorage.getItem('token');
    console.log(token);
    const header =new HttpHeaders();
    header.append('Authorization', `Bearer ${token}`)
    return this.http.get("http://localhost:8222/logistiques/produitsDTO");
  }
  public saveProduit(produitsDTO : ProduitDTO):Observable<ProduitDTO>{
    return this.http.post<ProduitDTO>("http://localhost:8222/logistiques/produits",produitsDTO);
  }











  public getAllProduit ():Observable<Array<ProduitDTO>>{
    return this.http.get<Array<ProduitDTO>>("http://localhost:8091/logistiques/produits");
  }
  public getProduitById(id : number):Observable<ProduitDTO>{
    return this.http.get<ProduitDTO>("http://localhost:8091/logistiques/produit/"+id);
  }
  public updateProduit(id : string, produitDTO :ProduitDTO): Observable<ProduitDTO>{
    return this.http.put<ProduitDTO>("http://localhost:8091/logistiques/produitt/"+id ,produitDTO);
  }
  public  deleteProduit(id:string){
    return this.http.delete("http://localhost:8091/logistiques/produits/"+id);
  }

}
