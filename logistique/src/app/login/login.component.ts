import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup} from "@angular/forms";
import {AuthService} from "../services/auth.service";
import {Router} from "@angular/router";
import {UserLogin} from "../model/UserLogin";
import {UserCredential} from "../model/user";
import {AuthRequest} from "../model/usertestt";


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  formLogin!:FormGroup;
  user: AuthRequest = {
    username: '',
    password: ''
  };
  constructor(private fb : FormBuilder,private authService :AuthService,private router :Router) { }

  ngOnInit(): void {
    this.formLogin=this.fb.group({
      username: this.fb.control(""),
      password : this.fb.control("")
    })
  }


















  onSubmit() {
    let username =this.formLogin.value.username;
    let password =this.formLogin.value.password;
    this.user.username=username;
    this.user.password=password;
    this.authService.authenticate(this.user).subscribe(
      data=>{

        console.log(data);
        this.authService.loadddProfil(data);
        this.router.navigateByUrl("/home/produit")
      },
      error => {
        console.error('Erreur :', error);
      }
    );
  }











  /*handleLogin() {
    let username =this.formLogin.value.username;
    let password =this.formLogin.value.password;
    this.user.username=username;
    this.user.password=password;
    console.log("*************************")
    console.log(this.user);
    this.authService.loginUser(this.user).subscribe(
      (userCredential:UserCredential)=>{
        console.log(userCredential);
        this.authService.loadProfil(userCredential);
       this.router.navigateByUrl("/home")
      },
      (error)=>{
        console.error('erreur ::  ',error);
      }

    );

  }*/
}
