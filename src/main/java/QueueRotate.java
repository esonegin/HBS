public class QueueRotate {

    public Queue rotate(Queue queue, int n) {

        for (int i = 0; i < n; i++) {
            //Вставляем последний символ на первое место
            queue.enqueue(queue.array.get(queue.size() - 1));
            //Удаляем последний символ
            queue.dequeue();
        }
        return queue;
    }
}
