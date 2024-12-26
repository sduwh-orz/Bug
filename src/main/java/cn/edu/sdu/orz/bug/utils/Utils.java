package cn.edu.sdu.orz.bug.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * The Utils methods.
 */
@SuppressWarnings("unused")
public class Utils {
    /**
     * The standard dateFormat.
     */
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Get null property names for BeanUtils.copyProperties().
     *
     * @param source the source
     * @return the null properties
     */
    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();

        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        return emptyNames.toArray(new String[0]);
    }

    /**
     * Get result with pagination.
     *
     * @param <E>       the type parameter
     * @param <R>       the type parameter
     * @param queryPage the query page
     * @param querySize the query size
     * @param query     the query
     * @param toDTO     the toDTO method
     * @return the result with pagination
     */
    public static <E, R> Map<String, Object> pagination(
            Integer queryPage,
            Integer querySize,
            Function<Pageable, Page<E>> query,
            Function<E, R> toDTO
    ) {

        int page = 0;
        if (queryPage != null)
            page = max(queryPage - 1, 0);
        int pageSize = 10;
        if (querySize != null)
            pageSize = querySize;
        Pageable pageable = PageRequest.of(page, pageSize);

        Page<E> data = query.apply(pageable);

        Map<String, Object> result = new HashMap<>();
        result.put("data", data.getContent().stream().map(toDTO).collect(Collectors.toList()));
        result.put("total", data.getTotalElements());
        result.put("start", min((long) page * pageSize + 1, data.getTotalElements()));
        result.put("end", min((long) (page + 1) * pageSize, data.getTotalElements()));
        return result;
    }

    /**
     * Get a new random ID.
     *
     * @return the new random ID
     */
    public static String newRandomID() {
        return DigestUtils.md5DigestAsHex(String.valueOf(new Random().nextLong()).getBytes(StandardCharsets.UTF_8))
                .toUpperCase();
    }
}
