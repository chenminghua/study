# JAVA线程池 
Java通过Executors提供四种线程池
* **newCachedThreadPool**创建一个可缓存线程池，如果线程池长度超过处理需要，可灵活回收空闲线程，若无可回收线程，则创建新线程。
* **newFixedThreadPool** 创建一个定长的线程池，可以控制线程的最大并发数，如果超出了线程池长度，则超出的线程会在队列中等待
* **newScheduledThreadPool**创建一个定长线程池，支持定时以及周期性任务执行
* **newSingleThreadExecutor**创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，保证所有的任务按照指定的顺序（FIFO，LIFO，优先级）执行