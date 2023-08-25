import {Observable, throwError, BehaviorSubject, of} from 'rxjs';
import {Injectable} from '@angular/core';
import {
  HttpInterceptor,
  HttpRequest,
  HttpHandler,
  HttpEvent,
  HttpErrorResponse,
  HttpHeaders
} from '@angular/common/http';
import {retry, catchError, map} from 'rxjs/operators';

@Injectable()
export class JWTInterceptor implements HttpInterceptor {
  token: string = '';
  myToast: any;

  constructor() {
  }

  intercept(
    request: HttpRequest<any>,
    next: HttpHandler): Observable<HttpEvent<any>> {
    console.log(request.url.includes('login'));
    // @ts-ignore
    this.token = localStorage.getItem('token');
    const headers = new HttpHeaders({authorization: 'Bearer ' + this.token});
    console.log(this.token);


    request = request.clone({
      setHeaders: {
        authorization: `Bearer ${this.token}`
      }
    });

    return next.handle(request).pipe(
      catchError((error: HttpErrorResponse) => {
        console.log(error)
        let errorMessage = 'An error occurred';
        if (error.status === 401) {
          errorMessage = 'Invalid credentials. Please check your email and password.';
        }
        return throwError(errorMessage);
      })
    );

  }
}
