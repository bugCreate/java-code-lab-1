package com.learn.collection.list;

import java.util.Objects;
import java.util.Random;

public class SkipList {
    private Node head, tail;
    private Random random = new Random();
    private int size = 0;
    private int level;
    private static final double PROBABILITY = 0.5;

    public SkipList() {
        clear();
    }

    public void clear() {
        head = new Node(Node.HEAD_KEY);
        tail = new Node(Node.TAIL_KEY);
        horizontalLink(head, tail);
        level = 0;
        size = 0;
    }

    private void insert(Node p, Node q) {
        q.right = p.right;
        q.left = p;
        p.right = q;
    }

    private void horizontalLink(Node p, Node q) {
        p.left = q;
        q.right = p;
    }

    private void vertiacallLink(Node p, Node q) {
        p.down = q;
        q.up = p;
    }

    private Node findNode(int key) {
        Node p = head;
        while (true) {
            while (p.right.getK() != Node.TAIL_KEY && p.right.getK() <= key) {
                p = p.right;
            }
            if (p.getDown() != null) {
                p = p.down;
            } else {
                break;
            }
        }
        return p;
    }

    public Node search(int key) {
        Node p = findNode(key);
        if (p.getK() == key) {
            return p;
        } else {
            return null;
        }
    }

    public void put(int key) {
        Node p = findNode(key);
        if (p.getK() == key) {
            return;
        }
        Node q = new Node(key);
        insert(p, q);
        int currentLevel = 0;
        while (random.nextDouble() < PROBABILITY) {
            if (currentLevel > level) {
                Node h = new Node(Node.HEAD_KEY);
                Node t = new Node(Node.TAIL_KEY);
                horizontalLink(h, t);
                vertiacallLink(h, head);
                vertiacallLink(t, tail);
                level++;
                head = h;
                tail = t;
            }
            while (p.getUp() == null) {
                p = p.left;
            }
            p = p.getUp();
            Node e = new Node(key);
            insert(p, e);
            vertiacallLink(e, q);
            q = e;
            currentLevel++;
        }
        size++;
    }

    class Node {
        public Node(int k) {
            this.k = k;
        }

        private int k;
        private Node right, left, up, down;
        public static final int HEAD_KEY = Integer.MAX_VALUE;
        public static final int TAIL_KEY = Integer.MIN_VALUE;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return k == node.k;
        }

        @Override
        public int hashCode() {
            return Objects.hash(k);
        }

        public int getK() {
            return k;
        }

        public void setK(int k) {
            this.k = k;
        }

        public Node getRight() {
            return right;
        }

        public void setRight(Node right) {
            this.right = right;
        }

        public Node getLeft() {
            return left;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public Node getUp() {
            return up;
        }

        public void setUp(Node up) {
            this.up = up;
        }

        public Node getDown() {
            return down;
        }

        public void setDown(Node down) {
            this.down = down;
        }
    }


}
