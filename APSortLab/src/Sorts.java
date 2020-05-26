
/**
 * Write a description of class isort here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sorts
{
    enum ListType {Standard, Bubble, Insert, Select};
    ListType listType = ListType.Standard;
    
    private int[] list;
    private int[] blist; int bcompares = 0; int bswaps = 0;
    private int[] ilist; int icompares = 0; int iswaps = 0;
    private int[] slist; int scompares = 0; int sswaps = 0;

    /**
     * Constructor for objects of class isort
     */
    public Sorts()
    {
        int size = 50;
        list = new int[size];
        for (int i = 0; i < list.length; i++)
            list[i] = (int)(Math.random() * size) + 1;
            
        blist = list.clone();
        this.BubbleSort();
        ilist = list.clone();
        this.InsertionSort();
        slist = list.clone();
        this.SelectionSort();
    }
    
    public String toString() {
        int[] list;
        
        switch(listType) {
            case Standard:
                System.out.println("Original List");
                list = this.list;
                break;
            case Bubble:
                System.out.println("Bubble Sort -- "
                  + " Operations: " + (this.bcompares + this.bswaps)
                  + " Compares: " + this.bcompares
                  + " Swaps: " + this.bswaps);
                list = this.blist;
                break;
            case Select:
            	System.out.println("Selection Sort -- "
                        + " Operations: " + (this.scompares + this.sswaps)
                        + " Compares: " + this.scompares
                        + " Swaps: " + this.sswaps);
                      list = this.slist;
                      break;
            case Insert:
                System.out.println("Insertion Sort -- "
                  + " Operations: " + (this.icompares + this.iswaps)
                  + " Compares: " + this.icompares
                  + " Swaps: " + this.iswaps);
                list = this.ilist;
                break;
            default:
                System.out.println("Insertions Sort -- "
                  + " Operations: " + (this.icompares + this.iswaps)
                  + " Compares: " + this.icompares
                  + " Swaps: " + this.iswaps);
                list = this.ilist;
        }
                
        String output = "[";
        for (int i = 0; i < list.length; i++)
            output += " " + list[i];
        return output +" ]";    
    }
    
    private int[] BubbleSort() { 
        
        // iterate list, one less than length
        for (int i = 0; i < blist.length - 1; i++) {
            
            // bubble sort key logic
            for (int k = 1; k < blist.length - i; k++) {
                
                // analytics
                this.bcompares++; // compare counter
                
                // bubble sort swap logic
                if (blist[k-1] > blist[k]) {
                    int swap = blist[k];
                    blist[k] = blist[k-1];
                    blist[k-1] = swap;
               
                    // analytics
                    this.bswaps++; // swap counter
                }
            
            }
            
        }
        return blist;
    }

    
    private int[] InsertionSort() {

        // iterate list, one less than length
        for (int i = 0; i < ilist.length - 1; i++) {
            
            // insertion sort key logic
            int k = i + 1;
            int swap = ilist[k];            
            while( k > 0 && swap < ilist[k-1]) {
                ilist[k] = ilist[k-1];
                k--;
                
                // analytics
                this.icompares++; // compare counter
                this.iswaps++; // shift counter
            }
            ilist[k] = swap;
            
            this.iswaps++;  // increment swap counter
            
        }
        
        return ilist;
    }
    
    private int[] SelectionSort() {
    	Integer lowest = null;
    	int temp;
    	for(int i = 0;  i<slist.length; i++)
    	{
    		for(int j = i; j<slist.length; j++) {
    			if(lowest == null || slist[lowest]>slist[j]) {
    				lowest=j;
    			}
    			this.scompares++; //Technically two each time but my implementation is just bad just don't worry about it
    		}
    		temp = slist[i];
    		slist[i]=slist[lowest];
    		slist[lowest]=temp;
    		lowest=null;
    		this.sswaps++;
    	}
    	return slist;
    }

    /*
     * Assessment on best sort:
     * 
     * Bubble is just bad, having both quadratic-time comparisons and swaps which wouldn't matter if we had one that was exponential or something but it's not like we're working with bogosorts here
     * 
     * Insertion is good but inconsistent. Both insertion and selection have quadratic comparisons, but insertion's worst case has quadratic swaps while selection has linear swaps almost no matter what. Iirc I read somewhere that insertion is better on average, and while either can come out on top for a given list, I'd take the consistency of selection in most situations
     * 
     * Both insertion and selection aren't the best you could do, though. Merge sort is really good and also fairly easy to implement. Cycle and heap sorts are also objectively better than both these sorts.
     * 
     */
    
    
    /**
     *
     */
    public static void main(String[] args)
    {
        // Original List
        Sorts is = new Sorts();
        System.out.println(is);
        
        // Bubble Sort
        is.listType = ListType.Bubble;
        System.out.println(is);
        
        // Insertion Sort
        is.listType = ListType.Insert;
        System.out.println(is);
        
        //Selection Sort
        is.listType = ListType.Select;
        System.out.println(is);
    }
}
