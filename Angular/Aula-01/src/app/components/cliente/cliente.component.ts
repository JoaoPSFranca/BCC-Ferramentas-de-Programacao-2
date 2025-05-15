import { Component, inject, OnInit } from '@angular/core';
import { ClienteService } from '../../services/cliente/cliente.service';
import { Observable } from 'rxjs';
import { AsyncPipe } from '@angular/common';

@Component({
  selector: 'app-cliente',
  imports: [AsyncPipe],
  templateUrl: './cliente.component.html',
  styleUrl: './cliente.component.scss'
})
export class ClienteComponent implements OnInit {

  private clienteService = inject(ClienteService);
  protected cliente$ = new Observable<any>();

  constructor() {
  }

  ngOnInit(): void {
    console.log("ngOnInit");
    this.buscarClientes();
  }

  public buscarClientes() {
      this.cliente$ = this.clienteService.buscarClientes();
  }

  public remover(id:number){
      this.clienteService.remover(id);
  }

}