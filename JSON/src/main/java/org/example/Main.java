package org.example;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        // рабочие
        Worker worker1 = new Worker("Иван", "Сергеевич", "Максютин",
                                    LocalDate.of(2020, 4, 13),
                                    LocalDate.of(2022, 5, 21));

        Worker worker2 = new Worker("Петр", "Андреевич", "Арбузов",
                                    LocalDate.of(2017, 1, 20));

        Worker worker3 = new Worker("Елена", "Александровна", "Калинова",
                                    LocalDate.of(2021, 12, 1));

        // типы подошвы
        Sole sole1 = new Sole("кожа", 21, "ООО \"КожЗамЗавод\"");
        Sole sole2 = new Sole("полиуретан", 23, "ЗАО \"СтельКом\"");
        Sole sole3 = new Sole("резина", 22, "ИП Киреев О.М.");
        Sole sole4 = new Sole("каучук", 25, "ОАО \"ОбувТовары\"");

        // кроссовки
        Sneakers[] sneakers = {
                new Sneakers("S0001", worker2, sole3, "искусственная кожа"),
                new Sneakers("S0002", worker2, sole2, "натуральная кожа"),
                new Sneakers("S0003", worker2, sole1, "искусственная кожа"),
                new Sneakers("S0004", worker2, sole4, "синтетика"),

                new Sneakers("S0005", worker1, sole1, "натуральная кожа"),
                new Sneakers("S0006", worker1, sole2, "синтетика"),
                new Sneakers("S0007", worker1, sole1, "натуральная кожа"),
                new Sneakers("S0008", worker1, sole1, "синтетика"),

                new Sneakers("S0009", worker3, sole3, "искусственная кожа"),
                new Sneakers("S0010", worker3, sole4, "синтетика"),
                new Sneakers("S0011", worker3, sole4, "натуральная кожа"),
                new Sneakers("S0012", worker3, sole2, "искусственная кожа")
        };

        File file = new File("target/sneakers.json");

        // сериализация
        ObjectMapper mapper = new ObjectMapper().findAndRegisterModules();;
        mapper.writerWithDefaultPrettyPrinter().writeValue(file, sneakers);

        // десериализация
        Sneakers[] sneakers_list = mapper.readValue(file, Sneakers[].class);

        for (Sneakers s : sneakers_list) {
            System.out.println("\nID : " + s.getId() +
                    "\nрабочий :" + "\n\tимя : " + s.getWorker().getName()
                                  + "\n\tотчество : " + s.getWorker().getMidName()
                                  + "\n\tфамилия : " + s.getWorker().getLastName()
                                  + "\n\tнанят : " + s.getWorker().getHired().toString()
                                  + "\n\tуволен : " + ((s.getWorker().getFired() != null)
                                                        ? s.getWorker().getFired().toString()
                                                        : "---") +
                    "\nподошва : " + "\n\tматериал : " + s.getSole().getMaterial()
                                   + "\n\tразмер : " + s.getSole().getSize()
                                   + "\n\tпроизводитель : " + s.getSole().getProducer() +
                    "\nобивка : " + s.getUpperMaterial() + "\n");
        }

        // лямбда-выражения

        // 1. Группировка кроссовок с одним типом подошвы
        Stream<Sneakers> sneakersStream = Stream.of(sneakers);
        Map<String, List<Sneakers>> bySoleMaterial = sneakersStream.collect(Collectors.groupingBy((Sneakers s) -> s.getSole().getMaterial()));

        System.out.println("1. Группировка кроссовок с одним типом подошвы:");
        bySoleMaterial.forEach((String k, List<Sneakers> v) -> {
            System.out.print('\n' + k + " : ");
            v.forEach((Sneakers s) -> System.out.print(s.getId() + " "));
        });

        // 2. Группировка кроссовок с одним производителем подошвы
        sneakersStream = Stream.of(sneakers);
        Map<String, List<Sneakers>> bySoleProducer = sneakersStream.collect(Collectors.groupingBy((Sneakers s) -> s.getSole().getProducer()));

        System.out.println("\n\n2. Группировка кроссовок с одним производителем подошвы:");
        bySoleProducer.forEach((String k, List<Sneakers> v) -> {
            System.out.print('\n' + k + " : ");
            v.forEach((Sneakers s) -> System.out.print(s.getId() + " "));
        });

        // 3. Кроссовки, созданные ещё не уволенными авторами
        sneakersStream = Stream.of(sneakers);
        List<Sneakers> byNonFiredWorkers = sneakersStream.filter(s -> s.getWorker().getFired() == null).toList();

        System.out.println("\n\n3. Кроссовки, созданные ещё не уволенными авторами:\n");
        byNonFiredWorkers.forEach(s -> System.out.print(s.getId() + " "));

        // 4. Группировка кроссовок по автору
        sneakersStream = Stream.of(sneakers);
        Map<Worker, List<Sneakers>> byWorker = sneakersStream.collect(Collectors.groupingBy(Sneakers::getWorker));

        System.out.println("\n\n4. Группировка кроссовок по автору:");
        byWorker.forEach((Worker k, List<Sneakers> v) -> {
            System.out.print('\n' + k.getLastName() + " " + k.getName() + " " + k.getMidName() + " : ");
            v.forEach((Sneakers s) -> System.out.print(s.getId() + " "));
        });
    }
}