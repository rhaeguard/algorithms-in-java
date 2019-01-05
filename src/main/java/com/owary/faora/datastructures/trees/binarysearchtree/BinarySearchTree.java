package com.owary.faora.datastructures.trees.binarysearchtree;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node<T> root;

    public BinarySearchTree(){}

    public void add(T item){
        Node<T> node = new Node<>(item);
        Node<T> temp = null;
        Node<T> pointer = root;

        while(pointer!=null){
            temp = pointer;
            if(pointer.compareTo(node)<0){
                pointer = pointer.right();
            }else{
                pointer = pointer.left();
            }
        }
        node.parent(temp);
        if(temp==null){
            root = node;
        }else if(temp.compareTo(node)<0){
            temp.right(node);
        }else{
            temp.left(node);
        }
    }

    public Node<T> search(T item){return search(item, root);}

    private Node<T> search(T item, Node<T> root){
        if(item.compareTo(root.data())>0){
            return search(item, root.right());
        }else if(item.compareTo(root.data())<0){
            return search(item, root.left());
        }else{
            return root;
        }
    }

    public boolean contains(T item){
        boolean res;
        try{
            res = search(item)!=null;
        }catch (NullPointerException e){
            res = false;
        }
        return res;
    }

    public Node<T> min(){
        return this.min(root);
    }

    private Node<T> min(Node<T> root){
        Node<T> temp = root;
        while (temp.left()!=null){
            temp = temp.left();
        }
        return temp;
    }

    public Node<T> max(){
        Node<T> temp = root;
        while (temp.right()!=null){
            temp = temp.right();
        }
        return temp;
    }

    private void transplant(Node<T> u, Node<T> v){
        if(u.parent()==null){
            this.root = v;
        }else if(u.equals(u.parent().left())){
            u.parent().left(v);
        }else{
            u.parent().right(v);
        }
        if(v!=null){
            v.parent(u.parent());
        }
    }

    public void delete(T item){
        Node<T> el = search(item);
        if(el.left()==null){
            transplant(el, el.right());
        }else if(el.right()==null){
            transplant(el, el.left());
        }else{
            Node<T> temp = min(el.right());
            if(!temp.parent().equals(el)){
                transplant(temp, temp.right());
                temp.right(el.right());
                temp.right().parent(temp);
            }
            transplant(el, temp);
            temp.left(el.left());
            temp.left().parent(temp);
        }
    }

    private Node<T> successor(Node<T> node){
        Node<T> temp = node.right();
        if(temp.left()!=null){
            return this.min(temp);
        }
        temp = search(node.data()).parent();
        while (temp!=null && temp.right().equals(node)){
            node = temp;
            temp = temp.parent();
        }
        return temp;
    }

    public void inorder(){inorder(root);}

    public void postorder(){postorder(root);}

    public void preorder(){preorder(root);}

    private void inorder(Node<T> node){

        if(node!=null){
            inorder(node.left());
            System.out.println(node);
            inorder(node.right());
        }
    }

    private void postorder(Node<T> node){
        if(node!=null){
            postorder(node.left());
            postorder(node.right());
            System.out.println(node);
        }
    }

    private void preorder(Node<T> node){
        if(node!=null){
            System.out.println(node);
            preorder(node.left());
            preorder(node.right());
        }
    }

}
