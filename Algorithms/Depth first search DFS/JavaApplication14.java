/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication14;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Node {

    private String number;
    private boolean visited;
    private List<Node> childlist;

    public Node(String number) {
        this.number = number;
        this.childlist = new ArrayList();
    }

    public void addneighbour(Node node) {
        this.childlist.add(node);
    }

    @Override
    public String toString() {
        return this.number;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public List<Node> getChildlist() {
        return childlist;
    }

    public void setChildlist(List<Node> childlist) {
        this.childlist = childlist;
    }
}

class DFS {

    private Stack<Node> stack;

    public DFS() {
        this.stack = new Stack<>();
    }

    public void dfs(List<Node> nodelist) {
        for (Node n : nodelist) {
            if (!n.isVisited()) {
                n.setVisited(true);
                dfswithstack(n);
            }
        }
    }

    public void dfswithstack(Node rootnode) {
        this.stack.add(rootnode);
        rootnode.setVisited(true);
        while (!stack.isEmpty()) {
            Node actualNode = this.stack.pop();
            System.out.println(actualNode + "");

            for (Node n : actualNode.getChildlist()) {
                if (!n.isVisited()) {
                    n.setVisited(true);
                    this.stack.push(n);
                }
            }
        }
    }
}

public class JavaApplication14 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.print("enter the name:\n");
        System.out.print("1st node name:");
        String a=sc.next();
        Node N0 = new Node(a);
        System.out.print("2nd node name:");
        String b=sc.next();
        Node N1 = new Node(b);
        System.out.print("3rd node name:");
        String c=sc.next();
        Node N2 = new Node(c);
        System.out.print("4th node name:");
        String d=sc.next();
        Node N3 = new Node(d);
        System.out.print("5th node name:");
        String e=sc.next();
        Node N4 = new Node(e);
        System.out.print("6th node name:");
        String f=sc.next();
        Node N5 = new Node(f);
        System.out.print("7th node name:");
        String g=sc.next();
        Node N6 = new Node(g);
        System.out.print("8th node name:");
        String h=sc.next();
        Node N7 = new Node(h);

        List<Node> list = new ArrayList<>();

        N0.addneighbour(N1);
        N0.addneighbour(N2);
        N0.addneighbour(N3);
        N0.addneighbour(N4);
        N1.addneighbour(N5);
        N2.addneighbour(N5);
        N3.addneighbour(N6);
        N4.addneighbour(N6);
        N5.addneighbour(N7);
        N6.addneighbour(N7);
        list.add(N0);
        list.add(N1);
        list.add(N2);
        list.add(N3);
        list.add(N4);
        list.add(N5);
        list.add(N6);
        list.add(N7);
        DFS d1 = new DFS();
        d1.dfs(list);

    }

}
