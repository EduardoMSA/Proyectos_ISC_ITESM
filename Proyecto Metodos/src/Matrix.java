/*
 * Eduardo Méndez
 * A01632947
 */
import java.util.Random;

public class Matrix {
	private int m;
	private int n;
	private Double[][] data;
	
	public Matrix() {
		this.n=1;
		this.m=1;
		this.data = new Double[this.m][this.n];
		this.setZero();
	}
	
	public Matrix(int m, int n) {
		this.n=n;
		this.m=m;
		this.data = new Double[this.m][this.n];
		this.setZero();
	}
	
	public Matrix(int orden) {
		this.n=orden;
		this.m=orden;
		this.data = new Double[this.m][this.n];
		this.setIdentity();
	}
	
	public Matrix(int m, int n, Double[] data) {
		this.n=n;
		this.m=m;
		this.data = new Double[this.m][this.n];
		for(int i = 0; i < this.m; i++) {
			 for(int j = 0; j < this.n; j++) {
				 this.data[i][j]=data[(i*n) + j];
			 }
		 }
	}
	
	public Matrix(Matrix matriz) {
		this.n=matriz.getM();
		this.m=matriz.getN();
		this.data = new Double[this.m][this.n];
		for(int i = 0; i < this.m; i++) {
			 for(int j = 0; j < this.n; j++) {
				 this.data[i][j]=matriz.getData()[i][j];
			 }
		 }
	}
	
	public Matrix(Double[][] matriz) {
		this.m = matriz.length;
		this.n = matriz[0].length;
		this.data=matriz;
		
	}
	
	public Matrix union(Matrix matriz) {
		Double[] data = new Double[this.m * (this.n+matriz.getN())];
		
		for(int i = 0 ; i<this.m; i++) {
			for(int j = 0; j<this.n; j++) {
				data[i*(this.n+matriz.getN()) + j]=this.data[i][j];
			}
		}
		for(int i = 0 ; i<this.m; i++) {
			for(int j = 0; j<this.n; j++) {
				data[i*(this.n+matriz.getN()) + (j+this.n)]=matriz.getData()[i][j];
			}
		}
		return new Matrix(this.m,this.n+matriz.getN(),data);
	}
	
	public Matrix inversa() {
		Matrix id = new Matrix(this.m);
		Matrix tmp = this.union(id);
		tmp.gaussJordanElimination(0.0000005);
		Double[] data = new Double[this.m*this.m];
		int counter = 0;
		for(int i = 0 ; i<tmp.m; i++) {
			for(int j = this.m ; j<tmp.n; j++) {
				data[counter++]=tmp.getData()[i][j];
			}
		}
		return new Matrix(this.m,this.m,data);
	}
	
	public void setIdentity() {
		this.setZero();
		for(int i = 0; i < this.m; i++) {
			this.data[i][i]=(double) 1;
		 }
	}
	
	public void setZero() {
		 for(int i = 0; i < this.m; i++) {
			 for(int j = 0; j < this.n; j++) {
				 this.data[i][j]=(double) 0;
			 }
		 }
	}
	
	public boolean suma(Matrix b) {
		if(b.getM()!=this.m || b.getN()!=this.n) {
			return false;
		}
		
		for(int i = 0; i< this.m; i++) {
			for(int j = 0; j<this.n; j++) {
				this.data[i][j]+=b.getData()[i][j];
			}
		}
		return true;
	}
	
	public boolean resta(Matrix b) {
		if(b.getM()!=this.m || b.getN()!=this.n) {
			return false;
		}
		
		for(int i = 0; i< this.m; i++) {
			for(int j = 0; j<this.n; j++) {
				this.data[i][j]-=b.getData()[i][j];
			}
		}
		return true;
	}
	
	public Matrix mult(Matrix b) {
		if(b.getM()!=this.n) {
			return null;
		}
		Double[] data = new Double[this.m*b.getN()];
		Double tmp = (double) 0;
		for (int i = 0; i < this.m; i++) {
			for (int l = 0; l < b.getN(); l++) {
				for (int j = 0; j < this.n; j++) {
					tmp+=this.data[i][j]*b.getData()[j][l];
				}
				data[i*b.getN()+l] = tmp;
				tmp=(double) 0;
			}
		}
		
		return new Matrix(this.m, b.getN(), data);
	}
	
	public Matrix transpuesta() {
		Double[] data = new Double[this.m*this.n];
		for (int i = 0; i < this.m; i++) {
			for (int j = 0; j < this.n; j++) {
				data[j*this.m + i] = this.data[i][j];
			}
		}
		
		return new Matrix(this.n,this.m,data);
	}
	
	public void setRandom() {
		Random rand = new Random();
		for(int i = 0; i < this.m; i++) {
			 for(int j = 0; j < this.n; j++) {
				 this.data[i][j]=rand.nextDouble();
			 }
		 }
	}
	
	public void swapRows(int i, int k) {
		double tmp;
		for (int j = 0; j < this.n; j++) {
			tmp = this.data[k][j];
			this.data[k][j] = this.data[i][j];
			this.data[i][j] = tmp;
		}
	}
	
	public String toString() {
		String msj = "";
		for(int i = 0; i < this.m; i++) {
			 for(int j = 0; j < this.n; j++) {
				 msj = msj + this.data[i][j] + " ";
			 }
			 msj = msj + "\n";
		 }
		return msj;
	}
	
	public boolean gaussJordanElimination(double tol) {
		double piv;
		for(int i = 0; i<this.m; i++) 
		{
			piv = this.data[i][i];
			if(Math.abs(piv)<=tol) 
			{
				
				int k;
				for(k = i+1;k<this.m;k++) 
				{
					if(Math.abs(this.data[k][i])>tol) 
					{
						this.swapRows(i, k);
						piv = this.data[i][i];
						break;
					}
				}
				if(k==this.m) 
				{
					return false;
				}
			}
			
			for (int j = 0; j< this.n;j++) 
			{
				this.data[i][j]/=piv;
			}
			for(int k = 0; k<this.m;k++) 
			{
				if(k!=i) {
					double factor = -this.data[k][i];
					for(int j = 0; j < this.n; j++)
					{
						this.data[k][j] = this.data[i][j] * factor + this.data[k][j];
					}
				}
			}
		}
		return true;
	}
	
	public Double[] getValues() {
		this.gaussJordanElimination(0.0000005);
		Double[] resultados = new Double[this.data.length];
		for(int i=0; i < resultados.length; i++) {
			resultados[i] = this.data[i][this.data[0].length-1];
		}
		return resultados;
	}
	
	
	public Double determinante(double tol) {
		double piv;
		for(int i = 0; i<this.m; i++) 
		{
			piv = this.data[i][i];
			if(Math.abs(piv)<=tol) 
			{
				
				int k;
				for(k = i+1;k<this.m;k++) 
				{
					if(Math.abs(this.data[k][i])>tol) 
					{
						this.swapRows(i, k);
						piv = this.data[i][i];
						break;
					}
				}
				if(k==this.m) 
				{
					return (double) 0;
				}
			}
			
			for(int k = i+1; k<this.m;k++) 
			{
				double factor = -this.data[k][i];
				for(int j = 0; j < this.n; j++)
				{
					this.data[k][j] = (this.data[i][j]/piv) * factor + this.data[k][j];
				}
				
			}
		}
		double result = data[0][0];
		for(int i = 1; i < this.m; i++) {
			result*=this.data[i][i];
		}
		
		return result;
	}

	public int getM() {
		return m;
	}

	public int getN() {
		return n;
	}

	public Double[][] getData() {
		return data;
	}
	
}
