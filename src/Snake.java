import java.awt.*;
import java.security.PrivateKey;

public class Snake {

    private Node head = null;
    private Node tail = null;
    private int size = 0;
    private Node n = new Node(20,30,Dir.D);

    public Snake(Node node){
        head = node;
        tail = node;
        size = 1;
    }

    public Snake(){
        head = n;
        tail = n;
        size = 1;
    }

    public void addToTail(){
        Node node = null;
        switch(tail.dir){
            case U:
                node = new Node(tail.row+1, tail.col, tail.dir );
                break;
            case D:
                node = new Node(tail.row-1, tail.col, tail.dir );
                break;
            case L:
                node = new Node(tail.row, tail.col+1, tail.dir );
                break;
            case R:
                node = new Node(tail.row, tail.col-1, tail.dir );
                break;
        }
        tail.next = node;
        tail = node;
        size++;
    }

    public void addToHead(){
        Node node = null;
        switch(head.dir){
            case U:
                node = new Node(head.row-1, head.col, head.dir );
                break;
            case D:
                node = new Node(head.row+1, head.col, head.dir );
                break;
            case L:
                node = new Node(head.row, head.col-1, head.dir );
                break;
            case R:
                node = new Node(head.row, head.col+1, head.dir );
                break;
        }
        node.next = head;
        head = node;
        size++;
    }

    public void draw(Graphics g){
        if(size <= 0){
            return;
        }
        for(Node n = head; n != null; n=n.next){
            n.draw(g);
        }
    }

    private class Node{
        int snakeWidth = Yard.BLOCK_SIZES;
        int snakeHeight = Yard.BLOCK_SIZES;
        int row ,col;
        Dir dir = Dir.L;
        public Node next;

        Node(int row, int col, Dir dir){
            this.row = row;
            this.col = col;
            this.dir = dir;
        }

        void draw(Graphics g){
            Color c = g.getColor();
            g.setColor(Color.BLACK);
            g.fillRect(Yard.BLOCK_SIZES * row , Yard.BLOCK_SIZES * col, snakeWidth, snakeHeight);
            g.setColor(c);
        }
    }


}
