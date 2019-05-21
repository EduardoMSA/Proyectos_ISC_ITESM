
public class Heap {
	private int size;
	private int[] heap;

	public Heap() {
		this(10);
	}

	public Heap(int size) {
		this.heap = new int[size];
		this.size = 0;
	}

	public Heap(int[] arreglo) {
		this.heap = arreglo;
		this.size = this.heap.length;
		this.heapify();
	}

	public void heapify() {
		int max;
		boolean isHeap;
		for (int index = (this.size / 2) - 1; index >= 0; index--) {
			isHeap = true;
			if (heap[index * 2 + 1] < heap[index * 2 + 2]) {
				max = index * 2 + 2;
			} else {
				max = index * 2 + 1;
			}

			if (this.heap[index] < this.heap[max]) {
				this.swap(index, max);
				if (max * 2 + 1 < this.size) {
					isHeap = false;
				}
			}

			while (!isHeap) {
				isHeap = true;
				int indexTmp = max;
				if (indexTmp * 2 + 2 < this.size) {
					if (heap[indexTmp * 2 + 1] < heap[indexTmp * 2 + 2]) {
						max = indexTmp * 2 + 2;
					} else {
						max = indexTmp * 2 + 1;
					}
				} else if (indexTmp * 2 + 1 < this.size) {
					max = indexTmp * 2 + 1;
				}

				if (this.heap[indexTmp] < this.heap[max]) {
					this.swap(indexTmp, max);
					if (max * 2 + 1 < this.size) {
						isHeap = false;
					}
				}
			}

		}
	}

	public int[] getHeap() {
		return this.heap;
	}

	public void insertar(int valor) {
		int index = this.size;
		boolean isHeap;
		if (this.size == this.heap.length) {
			this.agrandar();
		}
		this.heap[index] = valor;
		do {
			isHeap = true;
			if (this.heap[(index - 1) / 2] < valor && index != 0) {
				this.swap((index - 1) / 2, index);
				index = (index - 1) / 2;
				isHeap = false;
			}
		} while (!isHeap);
		this.size++;
	}
	
	
	private void swap(int origen, int destino) {
		int tmp = this.heap[origen];
		this.heap[origen] = this.heap[destino];
		this.heap[destino] = tmp;
	}

	private void agrandar() {
		int[] tmp = new int[this.heap.length * 2];
		for (int i = 0; i < this.heap.length; i++) {
			tmp[i] = this.heap[i];
		}
		this.heap = tmp;
	}

	public String toString() {
		String texto = "";
		for (int i = 0; i < this.size; i++) {
			texto += this.heap[i] + " ";
		}
		return texto;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 15, 60, 72, 70, 56, 32, 62, 92, 45, 30, 65 };
		Heap h = new Heap(a);
		System.out.println(h);
		Heap h2 = new Heap();
		h2.insertar(15);
		h2.insertar(60);
		h2.insertar(72);
		h2.insertar(70);
		h2.insertar(56);
		h2.insertar(32);
		h2.insertar(62);
		h2.insertar(92);
		h2.insertar(45);
		h2.insertar(30);
		h2.insertar(65);
		System.out.println(h2);

	}

}
