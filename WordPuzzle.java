import java.io.File;
import java.util.*;

public class WordPuzzle 
{
  public char[][] grid;
  
  public static final String dic = "abcdefghijklmnopqrstuvwxyz";
  
  public WordPuzzle(int row, int column) 
  {
    grid = new char[row][column];
    Random random = new Random();
    for(int i=0; i<row; i++) 
    {
      for(int j=0; j<column; j++) 
      {
        grid[i][j] = dic.charAt(random.nextInt(26));
      }
    }
   }
  
  public void display() 
  {
    if(grid == null || grid.length == 0) System.out.println("Error.Plese create a new grid.");
    System.out.println("the grid is displayed as : ");
    for(int i=0; i < grid.length; i++) 
    {
      for(int j=0; j < grid[0].length; j++) 
      {
        System.out.print(grid[i][j] + "  ");
      }
      System.out.print("\n");
    }
  }
  
  //check the grid with linkedlist  
  //check the grid horizontally
  public void hcontains(char[][] blank, MyLinkedList<String> list, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(list.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      hcontains(blank, list, i, j+1, sb, check, occupied);
      hcontains(blank, list, i, j-1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
//check the grid vertically
  public void vcontains(char[][] blank, MyLinkedList<String> list, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(list.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      vcontains(blank, list, i+1, j, sb, check, occupied);
      vcontains(blank, list, i-1, j, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
//check the grid leftdiagonally
  public void ldcontains(char[][] blank, MyLinkedList<String> list, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(list.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      ldcontains(blank, list, i-1, j-1, sb, check, occupied);
      ldcontains(blank, list, i+1, j+1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
//check the grid rightdiagonally
  public void rdcontains(char[][] blank, MyLinkedList<String> list, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(list.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }

      rdcontains(blank, list, i+1, j-1, sb, check, occupied);
      rdcontains(blank, list, i-1, j+1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
//public void contains(char[][] blank, MyLinkedList<String> list, int i, int j, StringBuilder sb, List<String> check) 
//{
//  if(sb.length() > 25) return;
//     for (int k=0; k + j < blank[i].length; k++)
//     {	  
//         sb.append(grid[i][j+k]);
//         if(list.contains(sb.toString())) 
//       {
//         if(!check.contains(sb.toString())) 
//       {
//         check.add(sb.toString());
//       }
//       }
//      }
//     for (int k=0; j-k >=0; k++)
//     {	  
//         sb.append(grid[i][j-k]);
//         if(list.contains(sb.toString())) 
//       {
//         if(!check.contains(sb.toString())) 
//       {
//         check.add(sb.toString());
//       }
//       }
//      } 
//     for (int k=0; i+k < blank.length; k++)
//     {	  
//         sb.append(grid[i+k][j]);
//         if(list.contains(sb.toString())) 
//       {
//         if(!check.contains(sb.toString())) 
//       {
//         check.add(sb.toString());
//       }
//       }
//      }
//     for (int k=0; i-k >=blank.length; k++)
//     {	  
//         sb.append(grid[i-k][j]);
//         if(list.contains(sb.toString())) 
//       {
//         if(!check.contains(sb.toString())) 
//       {
//         check.add(sb.toString());
//       }
//       }
//      }    
//}
  
 //check the grid with avltree as linkedlist  
  public void hcontains(char[][] blank, AvlTree<String> tree, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(tree.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      hcontains(blank, tree, i, j+1, sb, check, occupied);
      hcontains(blank, tree, i, j-1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
  
  public void vcontains(char[][] blank, AvlTree<String> tree, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(tree.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      vcontains(blank, tree, i+1, j, sb, check, occupied);
      vcontains(blank, tree, i-1, j, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
  public void ldcontains(char[][] blank, AvlTree<String> tree, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(tree.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      ldcontains(blank, tree, i-1, j-1, sb, check, occupied);
      ldcontains(blank, tree, i+1, j+1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
  public void rdcontains(char[][] blank, AvlTree<String> tree, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(tree.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }

      rdcontains(blank, tree, i+1, j-1, sb, check, occupied);
      rdcontains(blank, tree, i-1, j+1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
  
//check the grid with hashtable as linkedlist
  public void hcontains(char[][] blank, MyHashTable<String> table, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(table.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      hcontains(blank, table, i, j+1, sb, check, occupied);
      hcontains(blank, table, i, j-1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
  
  public void vcontains(char[][] blank, MyHashTable<String> table, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(table.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      vcontains(blank, table, i+1, j, sb, check, occupied);
      vcontains(blank, table, i-1, j, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
  public void ldcontains(char[][] blank, MyHashTable<String> table, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(table.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }
      ldcontains(blank, table, i-1, j-1, sb, check, occupied);
      ldcontains(blank, table, i+1, j+1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
  public void rdcontains(char[][] blank, MyHashTable<String> table, int i, int j, StringBuilder sb, List<String> check, boolean[][] occupied) 
  {
    if(sb.length() > 25) return;
    if(i < 0 || i >= blank.length || j < 0 || j>= blank[0].length || occupied[i][j]) return;
    sb.append(grid[i][j]);
    occupied[i][j] = true;
    if(table.contains(sb.toString())) 
    {
      if(!check.contains(sb.toString())) 
      {
        check.add(sb.toString());
      }
    }

      rdcontains(blank, table, i+1, j-1, sb, check, occupied);
      rdcontains(blank, table, i-1, j+1, sb, check, occupied);
      occupied[i][j] = false;
      sb.deleteCharAt(sb.length()-1);
  }
  

  
  public static void main(String[] args) 
  {
    Scanner scan = new Scanner(System.in);
    System.out.println(" row number: ");
    int row = scan.nextInt();
    System.out.println(" column number: ");
    int column = scan.nextInt();
    WordPuzzle words  = new WordPuzzle(row, column);
    words.display();
    char[][] grid = words.grid;
    MyLinkedList<String> linkedlist = new MyLinkedList<>();
    AvlTree<String> avltree = new AvlTree<>();
    MyHashTable<String> hashtable = new MyHashTable<>();
    List<String> check = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
 
    try {
      File file = new File("dictionary.txt");
      Scanner sc = new Scanner(file);
      while(sc.hasNextLine()) 
      {
        String str = sc.nextLine();
        linkedlist.add(str);
        avltree.insert(str);
        hashtable.insert(str);
      }
    }
    
    catch(Exception e) 
    {
      e.printStackTrace();
    }
         
    boolean[][] occupied = new boolean[row][column];
    
//  check the words with linkedlist 
    long startTime1 = System.currentTimeMillis();
    for(int i=0; i<row; i++) 
    {
      for(int j=0; j<column; j++) 
      { 
        words.hcontains(grid, linkedlist, i, j, sb, check,occupied);
        words.vcontains(grid, linkedlist, i, j, sb, check,occupied);
        words.ldcontains(grid, linkedlist, i, j, sb, check,occupied);
        words.rdcontains(grid, linkedlist, i, j, sb, check,occupied);
      }
    }
    System.out.println("The wordpuzzle checked by linkedlist contains " + check.size() + " words" );
    System.out.println("They are : ");
    for(String s : check) 
    {
      System.out.println(s);
    }
    long endTime1 = System.currentTimeMillis();
    System.out.println("The searching time used by linkedlist is: " +  (endTime1 - startTime1) + "ms");
    check.clear();
    sb.delete(0, sb.length());
        
//  check the words with avltree 
    long startTime2 = System.currentTimeMillis();
    for(int i=0; i<row; i++) 
    {
      for(int j=0; j<column; j++) 
      {
    	  words.hcontains(grid, avltree, i, j, sb, check,occupied);
          words.vcontains(grid, avltree, i, j, sb, check,occupied);
          words.ldcontains(grid, avltree, i, j, sb, check,occupied);
          words.rdcontains(grid, avltree, i, j, sb, check,occupied);
      }
    }
    System.out.println("The wordpuzzle checked by avltree contains " + check.size() + " words" );
    System.out.println("They are : ");
    for(String s : check) 
    {
      System.out.println(s);
    } 
    long endTime2 = System.currentTimeMillis();
    System.out.println("The searching time used by avltree is: " +  (endTime2 - startTime2) + "ms");
    check.clear();
    sb.delete(0, sb.length());
   
//  check the words with hashtable   
    long startTime3 = System.currentTimeMillis();
    for(int i=0; i<row; i++) 
    {
      for(int j=0; j<column; j++) 
      {
    	  words.hcontains(grid, hashtable, i, j, sb, check,occupied);
          words.vcontains(grid, hashtable, i, j, sb, check,occupied);
          words.ldcontains(grid, hashtable, i, j, sb, check,occupied);
          words.rdcontains(grid, hashtable, i, j, sb, check,occupied);
      }
    }
    System.out.println("The wordpuzzle checked by hashtable contains " + check.size() + " words" );
    System.out.println("They are : ");
    for(String s : check) 
    {
      System.out.println(s);
    }
    long endTime3 = System.currentTimeMillis();
    System.out.println("The searching time used by hashtable is: " +  (endTime3 - startTime3) + "ms");
    check.clear();
    sb.delete(0, sb.length());
   
    }
}
