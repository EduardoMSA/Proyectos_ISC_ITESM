class Matrix {
    constructor(m,n,datos){
        this.n=n;
        this.m=m;
        this.datos = new Array(2);
        this.datos=new Array(this.m);
        var k;
        for (k=0;k<this.m;k++){
            this.datos[k]=new Array(this.n);
        }
        var i;
        var j;
        for (i=0;i<this.m;i++){
            for (j=0;j<this.n;j++){
                this.datos[i][j]=datos[(i*this.n)+j];
            }
        }
    }

    swapRows(i,k){
        var tmp;
        var j;
        for (j=0;j<this.getN();j++){
            tmp=this.getDatos()[k][j];
            this.getDatos()[k][j]=this.getDatos()[i][j];
            this.getDatos()[i][j]=tmp;
        }
    }

    getN(){
        return this.n;
    }

    getM(){
        return this.m;
    }

    getDatos(){
        return this.datos;
    }

    gaussJordanElimination(tol){
        var piv;
        var factor;
        var i;
        var j;
        var k;

        for(i = 0; i<this.getM(); i++){
            piv = this.getDatos()[i][i];
            if(Math.abs(piv)<=tol){
                for(k=i+1;k<this.getM();k++){
                    if(Math.abs(this.getDatos()[k][i])>tol){
                        this.swapRows(i,k);
                        piv = this.getDatos()[i][i];
                        break;
                    }
                }
                if(k==this.getM()){
                    return false;
                }
            }

            for (j=0;j<this.getN();j++){
                this.datos[i][j]=this.datos[i][j]/piv;
            }

            for (k=0;k<this.getM();k++){
                if(k!=i){
                    factor = -(this.getDatos()[k][i]);
                    for(j=0;j<this.getN();j++){
                        this.datos[k][j]=this.datos[i][j]*factor+this.datos[k][j];
                    }
                }
            }
        }
        return true;
    }

    getValues(){
        this.gaussJordanElimination(0.0000005);
        var results;
        var i;
        results = new Array(this.getDatos().length);
        for (i=0;i<results.length;i++){
            results[i]=this.getDatos()[i][this.getDatos()[0].length-1]
        }
        return results;
    }
}

