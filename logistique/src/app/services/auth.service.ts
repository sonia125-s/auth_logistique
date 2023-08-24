import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {UserLogin} from "../model/UserLogin";
import {Observable} from "rxjs";
import {UserCredential} from "../model/user";
import {AuthRequest} from "../model/usertestt";
import {TokenToAngular} from "../model/TokenToAngular";


@Injectable({
  providedIn: 'root'
})
export class AuthService {
  isAuthenticated : boolean=false;
  roles : any ;
  username : any;
  id:any;
  isADMINISTRATEUR:boolean=false;
  isAGENTLOGISTIQUE:boolean=false;
  isTRANSPORTEUR:boolean=false;
  constructor(private http:HttpClient) { }

  public loginUser(user:UserLogin):Observable<UserCredential>{
    return this.http.post<UserCredential>("http://localhost:8090/users/login",user);
  }

  authenticate(user:AuthRequest):Observable<TokenToAngular> {
    console.log(user)
    return this.http.post<TokenToAngular>("http://localhost:8090/users/auth/token", user, {
      headers: new HttpHeaders({
        'Content-Type': 'application/json'
      })
    });
  }










  loadProfil(userCredential: UserCredential) {
    this.isAuthenticated=true;
    this.id=userCredential.id;
    this.username=userCredential.username;
    this.roles=userCredential.role;
    if( this.roles=='ADMINISTRATEUR'){
      this.isADMINISTRATEUR=true;
      this.isAGENTLOGISTIQUE=false;
      this.isTRANSPORTEUR=false;
    }
    if( this.roles=='AGENTLOGISTIQUE'){
      this.isADMINISTRATEUR=false;
      this.isAGENTLOGISTIQUE=true;
      this.isTRANSPORTEUR=false;
    }
    if( this.roles=='TRANSPORTEUR'){
      this.isADMINISTRATEUR=false;
      this.isAGENTLOGISTIQUE=false;
      this.isTRANSPORTEUR=true;
    }
  }

  logout() {
    this.isAuthenticated=false;
    this.isADMINISTRATEUR=false;
    this.isAGENTLOGISTIQUE=false;
    this.isTRANSPORTEUR=false;
  }

  loadddProfil(data: TokenToAngular) {
    localStorage.setItem('token',data.token);

  }
}
