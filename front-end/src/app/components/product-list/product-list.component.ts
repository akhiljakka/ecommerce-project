import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Product } from 'src/app/common/product';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products:Product[]=[];
  currentCategoryId:number=0;
  searchMode: boolean=false;
 
  constructor(private productService:ProductService,
    private route:ActivatedRoute
  ) { }

  ngOnInit(): void {
    this.route.paramMap.subscribe(()=>{
      this.listProducts();
    });
  }
  listProducts() {
this.searchMode = this.route.snapshot.paramMap.has('keyword');  

if(this.searchMode){
  //we will give the id as string we need to use + to type cast the string to int
  this.handleSearchProducts()
}
else {
  // giving default value of category is as 1
  this.handleListProduct();
}
  
  }
  handleSearchProducts(){
    const theKeyword : string =this.route.snapshot.paramMap.get('keyword')!;
    console.log(theKeyword);

    this.productService.searchProducts(theKeyword).subscribe(
      data => {
        console.log('searched products=' +JSON.stringify(data));
        this.products = data;
      }
    )

  }
  handleListProduct(){
    const hasCategoryId: boolean =this.route.snapshot.paramMap.has('id');
    
  
    
    if(hasCategoryId){
      //we will give the id as string we need to use + to type cast the string to int
      this.currentCategoryId=+this.route.snapshot.paramMap.get('id')!;
    }
    else {
      // giving default value of category is as 1
      this.currentCategoryId=1;
    }
    this.productService.getProductList(this.currentCategoryId).subscribe(
      data => {
        this.products = data;
      }
    )

  }

}
