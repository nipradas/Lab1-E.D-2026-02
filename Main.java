import java.time.Instant;
import java.time.Duration;
import java.util.Random;
import LISTAS.*;
import ARREGLOS.*;

interface Operation {
    void apply(int i);
}

public class Main {
    
    public static void exec(String struct, int size, String method, Operation operation) {
        boolean isSlowSearch = method.equals("Find") || method.equals("Erase") || method.equals("AddBefore") || method.equals("AddAfter") || method.equals("delete");
        boolean isSlowPushBack = method.equals("PushBack") && (struct.equals("ListaSNoT") || struct.equals("ListaDNoT"));
        boolean isSlowPopBack = method.equals("PopBack") && (struct.equals("ListaSNoT") || struct.equals("ListaSWT") || struct.equals("ListaDNoT"));
                if (size >= 1000000 && (isSlowSearch || isSlowPushBack || isSlowPopBack)) {
            System.out.println(struct + "," + method + "," + size + ",EXCEDIDO");
            return;
        }

        try {
            Instant start = Instant.now();
            for (int i = 0; i < size; i++) {
                operation.apply(i);
            }
            Instant finish = Instant.now();
            long timeElapsed = Duration.between(start, finish).toNanos(); 
            System.out.println(struct + "," + method + "," + size + "," + timeElapsed);
        } catch (OutOfMemoryError e) {
            System.out.println(struct + "," + method + "," + size + ",OOM");
            System.gc(); 
        } catch (Exception e) {
            System.out.println(struct + "," + method + "," + size + ",ERROR");
        }
    }

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000, 10000, 100000, 1000000, 10000000}; 
        Random r = new Random();

        System.out.println("Estructura,Metodo,Tamano,TiempoNS");

        testListaSNoT(sizes, r);
        testListaSWT(sizes, r);
        testListaDNoT(sizes, r);
        testListaDWT(sizes, r);
        testPilaArr(sizes, r);
        testColaArr(sizes, r);
    }

    public static void testListaSNoT(int[] sizes, Random r) {
        String n = "ListaSNoT";
        for (int s : sizes) { ListaSNoT<Integer> l = new ListaSNoT<>(); exec(n, s, "Empty", i -> l.empty()); }
        for (int s : sizes) { ListaSNoT<Integer> l = new ListaSNoT<>(); exec(n, s, "PushFront", i -> l.pushFront(r.nextInt(100000))); }
        for (int s : sizes) { ListaSNoT<Integer> l = new ListaSNoT<>(); exec(n, s, "PushBack", i -> l.pushBack(r.nextInt(100000))); }
        for (int s : sizes) { try { ListaSNoT<Integer> l = new ListaSNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "PopFront", i -> l.popFront()); } catch(OutOfMemoryError e){ System.out.println(n+",PopFront,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSNoT<Integer> l = new ListaSNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "PopBack", i -> l.popBack()); } catch(OutOfMemoryError e){ System.out.println(n+",PopBack,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSNoT<Integer> l = new ListaSNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "Find", i -> l.find(r.nextInt(s*2))); } catch(OutOfMemoryError e){ System.out.println(n+",Find,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSNoT<Integer> l = new ListaSNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "Erase", i -> l.erase(0)); } catch(OutOfMemoryError e){ System.out.println(n+",Erase,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSNoT<Integer> l = new ListaSNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "AddBefore", i -> l.addBefore(0, r.nextInt(100000))); } catch(OutOfMemoryError e){ System.out.println(n+",AddBefore,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSNoT<Integer> l = new ListaSNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "AddAfter", i -> l.addAfter(0, r.nextInt(100000))); } catch(OutOfMemoryError e){ System.out.println(n+",AddAfter,"+s+",OOM");} }
    }

    public static void testListaSWT(int[] sizes, Random r) {
        String n = "ListaSWT";
        for (int s : sizes) { ListaSWT<Integer> l = new ListaSWT<>(); exec(n, s, "Empty", i -> l.empty()); }
        for (int s : sizes) { ListaSWT<Integer> l = new ListaSWT<>(); exec(n, s, "PushFront", i -> l.pushFront(r.nextInt(100000))); }
        for (int s : sizes) { ListaSWT<Integer> l = new ListaSWT<>(); exec(n, s, "PushBack", i -> l.pushBack(r.nextInt(100000))); }
        for (int s : sizes) { try { ListaSWT<Integer> l = new ListaSWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "PopFront", i -> l.popFront()); } catch(OutOfMemoryError e){ System.out.println(n+",PopFront,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSWT<Integer> l = new ListaSWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "PopBack", i -> l.popBack()); } catch(OutOfMemoryError e){ System.out.println(n+",PopBack,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSWT<Integer> l = new ListaSWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "Find", i -> l.find(r.nextInt(s*2))); } catch(OutOfMemoryError e){ System.out.println(n+",Find,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSWT<Integer> l = new ListaSWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "Erase", i -> l.erase(0)); } catch(OutOfMemoryError e){ System.out.println(n+",Erase,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSWT<Integer> l = new ListaSWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "AddBefore", i -> l.addBefore(0, r.nextInt(100000))); } catch(OutOfMemoryError e){ System.out.println(n+",AddBefore,"+s+",OOM");} }
        for (int s : sizes) { try { ListaSWT<Integer> l = new ListaSWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "AddAfter", i -> l.addAfter(0, r.nextInt(100000))); } catch(OutOfMemoryError e){ System.out.println(n+",AddAfter,"+s+",OOM");} }
    }

    public static void testListaDNoT(int[] sizes, Random r) {
        String n = "ListaDNoT";
        for (int s : sizes) { ListaDNoT<Integer> l = new ListaDNoT<>(); exec(n, s, "Empty", i -> l.empty()); }
        for (int s : sizes) { ListaDNoT<Integer> l = new ListaDNoT<>(); exec(n, s, "PushFront", i -> l.pushFront(r.nextInt(100000))); }
        for (int s : sizes) { ListaDNoT<Integer> l = new ListaDNoT<>(); exec(n, s, "PushBack", i -> l.pushBack(r.nextInt(100000))); }
        for (int s : sizes) { try { ListaDNoT<Integer> l = new ListaDNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "PopFront", i -> l.popFront()); } catch(OutOfMemoryError e){ System.out.println(n+",PopFront,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDNoT<Integer> l = new ListaDNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "PopBack", i -> l.popBack()); } catch(OutOfMemoryError e){ System.out.println(n+",PopBack,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDNoT<Integer> l = new ListaDNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "Find", i -> l.find(r.nextInt(s*2))); } catch(OutOfMemoryError e){ System.out.println(n+",Find,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDNoT<Integer> l = new ListaDNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "Erase", i -> l.erase(0)); } catch(OutOfMemoryError e){ System.out.println(n+",Erase,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDNoT<Integer> l = new ListaDNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "AddBefore", i -> l.addBefore(0, r.nextInt(100000))); } catch(OutOfMemoryError e){ System.out.println(n+",AddBefore,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDNoT<Integer> l = new ListaDNoT<>(); for(int i=0; i<s; i++) l.pushFront(i); exec(n, s, "AddAfter", i -> l.addAfter(0, r.nextInt(100000))); } catch(OutOfMemoryError e){ System.out.println(n+",AddAfter,"+s+",OOM");} }
    }

    public static void testListaDWT(int[] sizes, Random r) {
        String n = "ListaDWT";
        for (int s : sizes) { ListaDWT<Integer> l = new ListaDWT<>(); exec(n, s, "Empty", i -> l.empty()); }
        for (int s : sizes) { ListaDWT<Integer> l = new ListaDWT<>(); exec(n, s, "PushFront", i -> l.pushFront(r.nextInt(100000))); }
        for (int s : sizes) { ListaDWT<Integer> l = new ListaDWT<>(); exec(n, s, "PushBack", i -> l.pushBack(r.nextInt(100000))); }
        for (int s : sizes) { try { ListaDWT<Integer> l = new ListaDWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "PopFront", i -> l.popFront()); } catch(OutOfMemoryError e){ System.out.println(n+",PopFront,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDWT<Integer> l = new ListaDWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "PopBack", i -> l.popBack()); } catch(OutOfMemoryError e){ System.out.println(n+",PopBack,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDWT<Integer> l = new ListaDWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "Find", i -> l.find(r.nextInt(s*2))); } catch(OutOfMemoryError e){ System.out.println(n+",Find,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDWT<Integer> l = new ListaDWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "Erase", i -> l.erase(0)); } catch(OutOfMemoryError e){ System.out.println(n+",Erase,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDWT<Integer> l = new ListaDWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "AddBefore", i -> l.addBefore(0, r.nextInt(100000))); } catch(OutOfMemoryError e){ System.out.println(n+",AddBefore,"+s+",OOM");} }
        for (int s : sizes) { try { ListaDWT<Integer> l = new ListaDWT<>(); for(int i=0; i<s; i++) l.pushBack(i); exec(n, s, "AddAfter", i -> l.addAfter(0, r.nextInt(100000))); } catch(OutOfMemoryError e){ System.out.println(n+",AddAfter,"+s+",OOM");} }
    }

    public static void testPilaArr(int[] sizes, Random r) {
        String n = "PilaArr";
        for (int s : sizes) { PilaArr<Integer> p = new PilaArr<>(); exec(n, s, "isEmpty", i -> p.isEmpty()); }
        for (int s : sizes) { PilaArr<Integer> p = new PilaArr<>(); exec(n, s, "push", i -> p.push(r.nextInt(100000))); }
        for (int s : sizes) { try { PilaArr<Integer> p = new PilaArr<>(); for(int i=0; i<s; i++) p.push(i); exec(n, s, "pop", i -> p.pop()); } catch(OutOfMemoryError e){ System.out.println(n+",pop,"+s+",OOM");} }
        for (int s : sizes) { try { PilaArr<Integer> p = new PilaArr<>(); for(int i=0; i<s; i++) p.push(i); exec(n, s, "peek", i -> p.peek()); } catch(OutOfMemoryError e){ System.out.println(n+",peek,"+s+",OOM");} }
        for (int s : sizes) { PilaArr<Integer> p = new PilaArr<>(); exec(n, s, "size", i -> p.size()); }
        for (int s : sizes) { try { PilaArr<Integer> p = new PilaArr<>(); for(int i=0; i<s; i++) p.push(i); exec(n, s, "delete", i -> p.delete(0)); } catch(OutOfMemoryError e){ System.out.println(n+",delete,"+s+",OOM");} }
    }

    public static void testColaArr(int[] sizes, Random r) {
        String n = "ColaArr";
        for (int s : sizes) { ColaArr<Integer> c = new ColaArr<>(); exec(n, s, "isEmpty", i -> c.isEmpty()); }
        for (int s : sizes) { ColaArr<Integer> c = new ColaArr<>(); exec(n, s, "enqueue", i -> c.enqueue(r.nextInt(100000))); }
        for (int s : sizes) { try { ColaArr<Integer> c = new ColaArr<>(); for(int i=0; i<s; i++) c.enqueue(i); exec(n, s, "dequeue", i -> c.dequeue()); } catch(OutOfMemoryError e){ System.out.println(n+",dequeue,"+s+",OOM");} }
        for (int s : sizes) { try { ColaArr<Integer> c = new ColaArr<>(); for(int i=0; i<s; i++) c.enqueue(i); exec(n, s, "front", i -> c.front()); } catch(OutOfMemoryError e){ System.out.println(n+",front,"+s+",OOM");} }
        for (int s : sizes) { ColaArr<Integer> c = new ColaArr<>(); exec(n, s, "size", i -> c.size()); }
        for (int s : sizes) { try { ColaArr<Integer> c = new ColaArr<>(); for(int i=0; i<s; i++) c.enqueue(i); exec(n, s, "delete", i -> c.delete(0)); } catch(OutOfMemoryError e){ System.out.println(n+",delete,"+s+",OOM");} }
    }
}