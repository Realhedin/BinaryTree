package com.company;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.company.tree.Node;

public class Main {

    private static int count;

    public static void main(String[] args) {
	// Tree iteration
        Node tree = new Node(10, "pasdf");
        tree.add(9,"te", tree);
        System.out.println((String) (tree.get(1, tree)));
        tree.add(9,"te1", tree);
        tree.add(6,"te1135", tree);
        tree.add(5, "adsf", tree);
        tree.add(8,"te1", tree);
        tree.add(12,"te131", tree);
        System.out.println(tree.get(5, tree));

        //delete 3
        tree.delete(9, tree);
        System.out.println(tree.get(5, tree));

        //horizontal check all nodes
        System.out.println("Horizontal");
        tree.horizontalWalkThrough(tree);
        System.out.println("Vertical (direct)");
        tree.verticalDirectWalk(tree);
        System.out.println("Vertical (indirect)");
        tree.verticalIndirectWalk(tree);
        System.out.println("Vertical (fromEnd)");
        tree.verticalFromEndWalk(tree);



        //zoneChanges
        System.out.println();
        ZoneId australiaId = ZoneId.of("Australia/Sydney");
        ZoneId moscowId = ZoneId.of("Europe/Moscow");
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        ZonedDateTime zonedDateTimeAustralia = ZonedDateTime.of(now, moscowId);
        System.out.println(zonedDateTimeAustralia);
        ZonedDateTime zonedDateTime = zonedDateTimeAustralia.withZoneSameInstant(australiaId);
        System.out.println(zonedDateTime);
        System.out.println();


        //word frequency in list
        String str = "hello, bye, ciao, bye, ciao";
        List<String> items = Arrays.asList(str.split("\\s*,\\s*"));
        List<String> wordsList = Arrays.asList("hello", "bye", "ciao", "bye", "ciao");
        Map<String, Long> collect =
                wordsList.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);

        //collections
        System.out.println(Collections.frequency(wordsList, "bye"));
        System.out.println(Collections.min(wordsList));
//        System.out.println(wordsList);
//        Collections.sort(wordsList);   //n*log(n)
//        System.out.println(wordsList);
        System.out.println(Collections.binarySearch(wordsList, "hello")); //log(n)


                //stream-api
        List<Integer> numbers = Arrays.asList(3, 4, 1, 2);
        Integer summOddNumbers = numbers.stream().filter(i -> i % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(-1);
        System.out.println(summOddNumbers);
        Integer reduce =  numbers.parallelStream()  //10*1 + 10*2 + 10*3 + 10*4
                .reduce(5, (identity, val) -> identity * val, (left, right) -> left + right); //3 args only with parallelStream
        System.out.println(reduce);
        Integer minReduce = numbers.stream().reduce(Integer.MAX_VALUE, (s1, s2) -> s1 < s2 ? s1 : s2);
        System.out.println(minReduce);
        Integer reduceMin2 = numbers.stream().reduce(Integer.MAX_VALUE, Integer::min);
        System.out.println(reduceMin2);

        List<String> stringList3 = Arrays.asList("aa", "bbb", "cc", "ddddd", "ffff");
        String reduce1 = stringList3.stream().reduce("", (str1, str2) -> str1.length() > str2.length() ? str1 : str2);
        System.out.println(reduce1);


        List<String> stringsDistinct = wordsList.stream().distinct().collect(Collectors.toList());
        System.out.println(stringsDistinct);
        wordsList.stream().map(String::toUpperCase).peek(s-> System.out.print(s + ", ")).count();
        System.out.println();

        wordsList.stream().sorted().forEach(s-> System.out.print(s+", "));
        System.out.println();
        wordsList.stream().sorted(Comparator.reverseOrder()).forEach(s-> System.out.print(s+", "));


        String[][] strings = {{"ad", "ka"}, {"oi,po"}};
        System.out.println(strings);
        List<String> collectFlatMap = Arrays.stream(strings).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(collectFlatMap);


        //exercises
        List<Person> personList = Arrays.asList(new Person("A", 16, Gender.MALE),
                new Person("B", 23, Gender.MALE),
                new Person("C", 42, Gender.FEMALE),
                new Person("D", 69, Gender.MALE));
        //male from 18 till 27
        List<Person> collect18and27 = personList.stream().filter(s -> s.getGender() == Gender.MALE).filter(s -> s.getAge()
                > 18 && s.getAge() < 27).collect(Collectors.toList());
        System.out.println(collect18and27);
        //men average age
        OptionalDouble average = personList.stream().filter(s -> s.getGender() == Gender.MALE).mapToInt
                (Person::getAge).average();
        System.out.println(average.getAsDouble());
        //working people (18-60 for men, 55 for women)
        long count = personList.stream().filter(s -> s.getAge() > 18).filter(s -> (s.getGender() == Gender.MALE && s
                .getAge() < 60) || (s.getGender() == Gender.FEMALE && s.getAge() < 55)).count();
        System.out.println(count);
        //person with max age
        Optional<Person> max = personList.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge()));
        System.out.println("Max age:" + max.get().getAge());

        //sort by age
        System.out.println("Sorting by age:");
        List<Person> collect3 = personList.stream().sorted((s1,s2) -> s1.getAge().compareTo(s2.getAge()))
                .collect(Collectors.toList());
        collect3.stream().forEach(s-> System.out.println(s.getAge()));
        System.out.println();


        List<String> stringList = Arrays.asList("a1", "a2", "a3", "a1");
        List<String> stringList2 = Arrays.asList("1,2,0", "4,5");
        //add "_1"
        List<String> collect_1 = stringList.stream().map(s -> s + "_1").collect(Collectors.toList());
        System.out.println(collect_1);
        //remove 1st symbol and return int[]
        int[] ints = stringList.stream().mapToInt(s->Integer.parseInt(s.substring(1))).toArray();
        System.out.println(ints);
        //get all numbers from 2nd collection with commas
        String[] strings1 = stringList2.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream()).toArray
                (String[]::new);
        System.out.println(strings1);

        List<Integer> reduceList = Arrays.asList(1, 2, 3, 4, 2);
        Integer sum = reduceList.stream().reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(sum);
        Integer maxList = reduceList.stream().max(Integer::compareTo).orElse(-1);
        System.out.println(maxList);
        Integer oddNumbers = reduceList.stream().filter(s -> s % 2 == 1).reduce((s1, s2) -> s1 + s2).orElse(0);
        System.out.println(oddNumbers);
        Integer collect1 = reduceList.stream().collect(Collectors.summingInt(s -> s % 2 == 1 ? s : 0));
        System.out.println(collect1);

        List<String> stringList1 = Arrays.asList("a1", "b2", "c3", "a1");
        Map<String, List<String>> collect2 = stringList1.stream().collect(Collectors.groupingBy(s -> s.substring(0,
                1)));
        System.out.println(collect2);




        //multithreading
        //try1
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
            String name = Thread.currentThread().getName();
            System.out.println("hello: " + name);
        });
        try {
            executorService.shutdown();
            executorService.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            System.out.println("interrupted!");
        } finally {
            if (!executorService.isTerminated()) {
                System.err.println("cancel non-finished tasks");
            }
            executorService.shutdownNow();
            System.out.println("shutdown killed");
        }

        //try2
        Callable<Integer> task = () -> {
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("Callable worked");
                return 123;
            } catch (InterruptedException e) {
                throw new IllegalStateException("task interrupted", e);
            }
        };
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(1);
        Future<Integer> future = fixedThreadPool.submit(task);
        System.out.println("future done? " + future.isDone());
        try {
            Integer result = future.get(500, TimeUnit.MILLISECONDS);
            System.out.println("future done? " + future.isDone());
            System.out.println("result: " + result);
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        } catch (TimeoutException e) {
            System.out.println("TimeoutException happened");
        } finally {
            fixedThreadPool.shutdownNow();
        }


        //try3
        ExecutorService executorService1 = Executors.newWorkStealingPool();
        List<Callable<String>> callables = Arrays.asList(
                () -> "task1",
                () -> "task2",
                () -> "task3"
        );
        try {
            executorService1.invokeAll(callables)
                    .stream()
                    .map(f -> {
                        try {
                            return f.get();
                        } catch (Exception e) {
                            throw new IllegalStateException(e);
                        }
                    })
            .forEach(System.out::println);
        } catch (InterruptedException e) {

        } finally {
            executorService1.shutdownNow();
        }
        System.out.println();

        //try4
        ExecutorService executor4 = Executors.newWorkStealingPool();
        List<Callable<String>> callables4 = Arrays.asList(
                callable("task1", 2),
                callable("task2", 1),
                callable("task3", 3));

        String result = null;
        try {
            result = executor4.invokeAny(callables4);
        } catch (InterruptedException e) {

        } catch (ExecutionException e) {

        }
        System.out.println(result);


        //try5
        System.out.println();
        try {
            ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
            Runnable task5 = () -> System.out.println("Scheduling: " + System.nanoTime());
            ScheduledFuture<?> scheduledFuture = scheduledExecutorService.schedule(task5, 3, TimeUnit.SECONDS);
            TimeUnit.MILLISECONDS.sleep(1337);
            long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
            System.out.println("Remaining delay: " + delay);

            int initialDelay = 0;
            int period = 1;
            scheduledExecutorService.scheduleAtFixedRate(task5, initialDelay, period, TimeUnit.SECONDS);
            Thread.sleep(3000);
            stop(scheduledExecutorService);
        } catch (InterruptedException e) {

        }



        //try6
        System.out.println();
        ConcurrentHelperMethods helperMethods = new ConcurrentHelperMethods();
        ExecutorService executorService2 = Executors.newFixedThreadPool(2);
        IntStream.range(0,10000)
                .forEach(i -> executorService2.submit(helperMethods::incrementReentrantLock));
        stop(executorService2);
        System.out.println(helperMethods.count);



        //try7 (WriteLock is exclusive, but readLock can be used in parallel)
        System.out.println();
        ExecutorService executorService7 = Executors.newFixedThreadPool(2);
        HashMap<String, String> stringHashMap = new HashMap<>();
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        executorService7.submit(() -> {
           reentrantReadWriteLock.writeLock().lock();
            try {
                sleep(1);
                stringHashMap.put("foo", "bar");
            } finally {
                reentrantReadWriteLock.writeLock().unlock();
                System.out.println("writeLocked is free");
            }
        });
        Runnable readTask = () -> {
            reentrantReadWriteLock.readLock().lock();
            try {
                System.out.println(stringHashMap.get("foo"));
                sleep(1);
            } finally {
                reentrantReadWriteLock.readLock().unlock();
            }
        };
        executorService7.submit(readTask);   //because no write lock, it can access readLock simultaneously
        executorService7.submit(readTask);
        stop(executorService7);





        //try8
        System.out.println();
        ExecutorService executorService8 = Executors.newFixedThreadPool(2);
        Map<String, String> map = new HashMap<>();
        StampedLock stampedLock = new StampedLock();
        executorService8.submit(() -> {
            long stamp = stampedLock.writeLock();
            try {
                sleep(1);
                map.put("foo", "bar");
            } finally {
                stampedLock.unlockWrite(stamp);
            }
        });
        Runnable readTask2 = () -> {
            long stamp = stampedLock.readLock();
            try {
                System.out.println(map.get("foo"));
                sleep(1);
            } finally {
                stampedLock.unlockRead(stamp);
            }
        };
        executorService8.submit(readTask2);
        executorService8.submit(readTask2);
        stop(executorService8);



        //try9
        System.out.println();
        ExecutorService executorService9 = Executors.newFixedThreadPool(2);
        StampedLock stampedLock2 = new StampedLock();
        executorService9.submit(() -> {
            long stamp = stampedLock2.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + stampedLock2.validate(stamp));
                sleep(1);
                System.out.println("Optimistic Lock Valid: " + stampedLock2.validate(stamp));
                sleep(2);
                System.out.println("Optimistic Lock Valid: " + stampedLock2.validate(stamp));
            } finally {
                stampedLock2.unlock(stamp);
            }
        });
        executorService9.submit(() -> {
            long stamp = stampedLock2.writeLock();
            try {
                System.out.println("Write Lock acquired");
                sleep(2);
            } finally {
                stampedLock2.unlock(stamp);
                System.out.println("Write done");
            }
        });
        stop(executorService9);


        //try10
        System.out.println();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        StampedLock lock = new StampedLock();
        executor.submit(() -> {
            int count1 = 0;
            long stamp = lock.readLock();
            try {
                if (count1 == 0) {
                    stamp = lock.tryConvertToWriteLock(stamp);
                    if (stamp == 0L) {
                        System.out.println("Could not convert to write lock");
                        stamp = lock.writeLock();
                    }
                    count1 = 23;
                }
                System.out.println(count1);
            } finally {
                lock.unlock(stamp);
            }
        });
        stop(executor);


        //try11
        System.out.println();
        ExecutorService executorService11 = Executors.newFixedThreadPool(10);
        Semaphore semaphore = new Semaphore(5);
        Runnable longRunningTask = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(3, TimeUnit.SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    sleep(5);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                throw new IllegalStateException(e);
            } finally {
                if (permit) {
                    semaphore.release();
                }
            }
        };
        IntStream.range(0, 10)
                .forEach(i -> executorService11.submit(longRunningTask));
        stop(executorService11);



        //try12
        System.out.println();
        System.out.println("AtomicInt:");
        AtomicInteger atomicInt = new AtomicInteger(0);
        ExecutorService executorService12 = Executors.newFixedThreadPool(2);
        IntStream.range(0, 1000)
                .forEach(i -> executorService12.submit(atomicInt::incrementAndGet));
        stop(executorService12);
        System.out.println(atomicInt.get());


        //try13
        System.out.println();
        System.out.println("AtomicInt: updateAndGet");
        AtomicInteger atomicInt13 = new AtomicInteger(0);
        ExecutorService executorService13 = Executors.newFixedThreadPool(2);
        IntStream.range(0, 1000)
                .forEach(i -> {
                    Runnable task13 = () ->
                            atomicInt13.updateAndGet(n -> n + 2);
                    executorService13.submit(task13);
                });
        stop(executorService13);
        System.out.println(atomicInt13.get());



        //try14
        System.out.println();
        System.out.println("ConcurrentMap:");
        ConcurrentMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("foo", "bar");
        concurrentHashMap.put("han", "solo");
        concurrentHashMap.put("r2", "d2");
        concurrentHashMap.put("c3", "p0");
        concurrentHashMap.forEach((k,v) -> System.out.printf("key=%s, value=%s", k, v));
        System.out.println();


        //try15
        System.out.println();
        System.out.println(ForkJoinPool.getCommonPoolParallelism());
        System.out.println("ConcurrentHashMap:");
        ConcurrentHashMap<String, String> concurrentHashMap1 = new ConcurrentHashMap<>();
        concurrentHashMap1.put("foo", "bar");
        concurrentHashMap1.put("han", "solo");
        concurrentHashMap1.put("r2", "d2");
        concurrentHashMap1.put("c3", "p0");
        concurrentHashMap1.forEach(1, (k,v) -> System.out.printf("key: %s; value: %s; thread: %s\n",
                k, v, Thread.currentThread().getName()));
        System.out.println();

        String result15 = concurrentHashMap1.search(1, (key, value) -> {
            System.out.println(Thread.currentThread().getName());
            if ("foo".equals(key)) {
                return value;
            }
            return null;
        });
        System.out.println("Result: " + result15);
        System.out.println();

        String resultReduce = concurrentHashMap1.reduce(1, (key, value) -> {
                    System.out.println("Transform: " + Thread.currentThread().getName());
                    return key + "=" + value;
                },
                (s1, s2) -> {
                    System.out.println("Reduce: " + Thread.currentThread().getName());
                    return s1 + ", " + s2;
                });

        System.out.println("Result: " + resultReduce);


    }

    //try4
    static Callable<String> callable(String result,long sleepSeconds) {
        return () -> {
            TimeUnit.SECONDS.sleep(sleepSeconds);
            return result;
        };
    }


    //step6
    public static void stop(ExecutorService executor) {
        try {
            executor.shutdown();
            executor.awaitTermination(60, TimeUnit.SECONDS);
        }
        catch (InterruptedException e) {
            System.err.println("termination interrupted");
        }
        finally {
            if (!executor.isTerminated()) {
                System.err.println("killing non-finished tasks");
            }
            executor.shutdownNow();
        }
    }


    public static void sleep(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }


}
